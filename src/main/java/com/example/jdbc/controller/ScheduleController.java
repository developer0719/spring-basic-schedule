package com.example.jdbc.controller;

import com.example.jdbc.dto.ScheduleRequestDto;
import com.example.jdbc.dto.ScheduleResponseDto;
import com.example.jdbc.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleService> saveSchedul(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.saveMemo(dto));
    }
    //전체 일정 조회 API
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }
    //선택 일정 수정 API (PUT)
    @PutMapping
    public ResponseEntity<String>updateSchedule(
            @RequestBody ScheduleRequestDto dto)
        boolean isUpdated = scheduleService.updateSchedule(id, requestDto);
    if(isUpdated){
        return ResponseEntity.ok("일정이 성공적으로 수정되었습니다");
    }
    return ResponseEntity.badRequest().body("비밀번호가 일치하지 않거나, 해당 일정이 존재하지 않습니다"
    )
}
    //선택 일정 삭제 API (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(
            @PathVariable long id;
            @RequestParam String password){

        boolean isDeleted = scheduleService.deleteSchedule(id,password);
        if(isDeleted){
            return ResponseEntity.ok("일정이 성공적으로 삭제되었습니다.")
        }
        return ResponseEntity.badRequest().body("비밀번호가 일치하지 않거나, 해당 일정이 존재하지 않습니다.")
        }
    )
