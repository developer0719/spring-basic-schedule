package com.example.jdbc.dto;

import com.example.jdbc.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String task;
    private String authorName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Entity -> DTO변환
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.authorName = schedule.getAuthorName();
        this.createdAt = schedule.getCreateAt();
        this.updatedAt = schedule.getUpdateAt();

    }
}