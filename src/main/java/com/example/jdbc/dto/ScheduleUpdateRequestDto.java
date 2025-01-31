package com.example.jdbc.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    private String task;
    private String authorName;
    private String password;
}
