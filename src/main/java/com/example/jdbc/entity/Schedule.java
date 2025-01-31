package com.example.jdbc.entity;

import com.example.jdbc.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //자동 증가 ID
    private Long id;

    @Column(nullable = false)
    private String task; // 할일

    @Column(nullable = false)
    private String authorName; // 작성자명

    @Column(nullable = false)
    private String password; //비밀번호(보안 필요)

    @Column(nullable = false)
    private LocalDateTime createAt; //작성일

    @Column(nullable = false)
    private LocalDateTime updateAt; //수정일

    public Schedule(ScheduleRequestDto dto) {
        this.task = dto.getTask();
        this.authorName = dto.getAuthorName();
        this.password = dto.getPassword();
        this.createAt = LocalDateTime.now();
        this.updateAt = this.createAt; // 최조 생성시, 수정일 = 작성일
    }
    //일정 수정 (비밀번호 확인)
    public boolean update(ScheduleRequestDto dto, String password) {
        if(!this.password.equals(password)){
            return false; // 비밀번호가 다르면 수정 불가

        }
        this.task = dto.getTask();
        this.authorName = dto.getAuthorName();
        this.updateAt = LocalDateTime.now(); // 수정 시점 업데이트
        return true;
    }
}
