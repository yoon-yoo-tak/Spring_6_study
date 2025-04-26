package com.example.microsns.repository.jpa;

import com.example.microsns.entity.BoardEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findAllByOrderByIdDesc(PageRequest of);

    List<BoardEntity> findByIdLessThanOrderByIdDesc(Long lastId, PageRequest of);
}
