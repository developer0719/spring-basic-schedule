package com.example.jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Memocontroller {

    private final MemoServic memoServic;

    @PostMapping("/memos")
    public ResponseEntity<MemoResposeDto> saveMemo(@RequestBody MemoRequestDto dto){
        return ResponseEntity.ok(memoService.saveMemo(dto));
    }
}
