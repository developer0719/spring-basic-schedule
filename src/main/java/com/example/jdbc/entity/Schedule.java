package com.example.jdbc.entity;

import com.example.jdbc.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //자동 증가 ID
    private Long id;

    private String task; // 할일

    private String authorName; // 작성자명

    private String password; //비밀번호(보안 필요)

    private LocalDateTime createAt; //작성일

    private LocalDateTime updateAt; //수정일

    public Schedule(ScheduleRequestDto dto) {
        this.task = dto.getTask();
        this.authorName = dto.getAuthorName();
        this.password = dto.getPassword();
        this.createAt = LocalDateTime.now();
        this.updateAt = this.createAt; // 최조 생성시, 수정일 = 작성일

    }



}
