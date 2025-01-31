package com.example.jdbc.service;

import com.example.jdbc.dto.ScheduleRequestDto;
import com.example.jdbc.dto.ScheduleResponseDto;
import com.example.jdbc.entity.Schedule;
import com.example.jdbc.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto saveMemo(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getContent());
    }


}
}