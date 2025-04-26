package com.example.microsns.domain;

import com.example.microsns.entity.BoardEntity;
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

    public BoardEntity toEntity() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(id);
        boardEntity.setTitle(title);
        boardEntity.setContent(content);
        boardEntity.setWriter(writer);
        boardEntity.setPassword(password);
        boardEntity.setCreatedAt(createdAt);
        boardEntity.setModifiedAt(modifiedAt);
        return boardEntity;
    }
}
