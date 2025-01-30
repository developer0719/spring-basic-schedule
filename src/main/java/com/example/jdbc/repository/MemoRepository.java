package com.example.jdbc.repository;

import com.example.jdbc.entity.Memo;

import java.awt.*;
import java.util.Optional;

public interface MemoRepository {

    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    List<Memo> findAll();
    Memo updateContent(Memo memo);
    void deleteById(Long id);
}
