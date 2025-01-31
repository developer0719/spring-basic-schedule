package com.example.jdbc.repository;

import com.example.jdbc.entity.Schedule;

import java.awt.*;
import java.util.Optional;

public interface ScheduleRepository {

    Schedule save(Schedule schedule);
    Optional<Schedule> findById(Long id);
    List<Schedule> findAll();
    Schedule updateContent(Schedule schedule);
    void deleteById(Long id);
}
