package com.example.jdbc.service;

import com.example.jdbc.dto.ScheduleRequestDto;
import com.example.jdbc.dto.ScheduleResponseDto;
import com.example.jdbc.entity.Schedule;
import com.example.jdbc.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
       //전체 일정 조회 API
      @GetMapping
       public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
            return ResponseEntity.ok(scheduleService.getAllSchedules());
    }


}
}