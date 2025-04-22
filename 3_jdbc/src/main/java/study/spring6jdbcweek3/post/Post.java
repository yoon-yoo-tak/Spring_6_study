package study.spring6jdbcweek3.post;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Post {
    private final Long postId;
    private final String title;
    private final String content;
    private int likes;

    // private 생성자
    private Post(Long postId, String title, String content, int likes) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    // 신규 생성 시 사용 (좋아요 기본값 0 강제)
    public static Post create(Long postId, String title, String content) {
        return new Post(postId, title, content, 0);
    }

    // DB 등에서 로딩할 때 사용
    public static Post of(Long postId, String title, String content, int likes) {
        return new Post(postId, title, content, likes);
    }
}