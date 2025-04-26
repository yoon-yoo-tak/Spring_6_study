package com.example.microsns.entity;

import com.example.microsns.domain.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile("jpa")
@Entity
@Getter
@Setter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    private String writer;

    @Lob
    private String content;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = LocalDateTime.now();
    }

    public Comment toComment() {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setBoardId(boardEntity.getId());
        comment.setWriter(writer);
        comment.setContent(content);
        comment.setPassword(password);
        comment.setCreatedAt(createdAt);
        comment.setModifiedAt(modifiedAt);
        return comment;
    }

    public static CommentEntity fromComment(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getId());
        commentEntity.setWriter(comment.getWriter());
        commentEntity.setContent(comment.getContent());
        commentEntity.setPassword(comment.getPassword());
        commentEntity.setCreatedAt(comment.getCreatedAt());
        commentEntity.setModifiedAt(comment.getModifiedAt());
        return commentEntity;
    }
}
