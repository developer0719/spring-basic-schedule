package com.example.jdbc.repository;

import com.example.jdbc.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {


    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Schedule save(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into schedule(content) values(?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, schedule.getContent());
            return ps;
        }, keyHolder);

        schedule.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        return schedule;
    }


    @Override
    public Optional<Schedule> findById(Long id) {
        List<Schedule> schedules = jdbcTemplate.query(
                "select * from schedule where id = ?",
                (rs, rowNum) -> new Schedule(rs.getLong("id"), rs.getString("content")),
                id
        );

        return schedules.stream().findAny();
    }

    @Override
    public List<Schedule> findAll() {
        return jdbcTemplate.query(
                "select * from schedule",
                (rs, rowNum) ->
                        new Schedule(rs.getLong("id"), rs.getString("content"))
        );
    }

    @Override
    public Schedule updateContent(Long id, String content) {
        jdbcTemplate.update(
                "update schedule set content = ? where id = ?",
                content,
                id
        );

        return jdbcTemplate.queryForObject(
                "select * from schedule where id = ?",
                (rs, rowNum) -> new Schedule(rs.getLong("id"), rs.getString("content")),
                id
        );
    }

    @Override
    public void delete(Schedule schedule) {
        jdbcTemplate.update(
                "delete from schedule where id = ?",
                schedule.getId()
        );
    }
}