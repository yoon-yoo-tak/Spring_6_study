package com.example.microsns.entity;

import com.example.microsns.domain.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    private String writer;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CommentEntity> comments = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = LocalDateTime.now();
    }

    public Board toBoard() {
        Board board = new Board();
        board.setId(this.id);
        board.setTitle(this.title);
        board.setContent(this.content);
        board.setWriter(this.writer);
        board.setPassword(this.password);
        board.setCreatedAt(this.createdAt);
        board.setModifiedAt(this.modifiedAt);
        return board;
    }

}
