package com.example.jdbc.repository;

import com.example.jdbc.entity.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

}
