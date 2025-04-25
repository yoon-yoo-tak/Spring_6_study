package com.example.microsns.controller;

import com.example.microsns.domain.Board;
import com.example.microsns.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping
    public List<Board> getBoards(@RequestParam(required = false) Long lastId){
        int pageSize = 10;
        if (lastId != null){
            return boardService.findOlderThan(lastId, pageSize);
        }else{
            return boardService.findRecent(pageSize);
        }
    }
}
