package com.example.microsns.entity;

import com.example.microsns.domain.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Setter
@Getter
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 지연 로딩 + N:1 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private BoardEntity board;

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
        comment.setWriter(writer);
        comment.setContent(content);
        comment.setPassword(password);
        comment.setCreatedAt(createdAt);
        comment.setModifiedAt(modifiedAt);
        return comment;
    }

    public static CommentEntity fromComment(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
//        commentEntity.setId(comment.getId());
        commentEntity.setWriter(comment.getWriter());
        commentEntity.setContent(comment.getContent());
        commentEntity.setPassword(comment.getPassword());
//        commentEntity.setCreatedAt(comment.getCreatedAt());
//        commentEntity.setModifiedAt(comment.getModifiedAt());
        return commentEntity;
    }
}
