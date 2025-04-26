package com.example.microsns.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
