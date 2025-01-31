package com.example.jdbc.controller;

import com.example.jdbc.dto.ScheduleRequestDto;
import com.example.jdbc.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleService> saveSchedul(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.saveMemo(dto));
    }
}
