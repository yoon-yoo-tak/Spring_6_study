package com.example.microsns.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long boardId;
    private String writer;
    private String content;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
