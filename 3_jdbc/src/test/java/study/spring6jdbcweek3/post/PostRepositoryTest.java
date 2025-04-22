package study.spring6jdbcweek3.post;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PostRepositoryTest {

    @AfterEach
    void clear() {
        PostRepository postRepository = new PostRepository();
        postRepository.deleteAll();
    }

    @DisplayName("PostRepository save 테스트")
    @Test
    void save() throws Exception {
        PostRepository postRepository = new PostRepository();

        Post post = Post.create(1L, "title", "content");

        postRepository.save(post);
    }

    @DisplayName("PostRepository get 테스트")
    @Test
    void get() throws Exception {
        // given
        PostRepository postRepository = new PostRepository();
        Long postId = 1L;

        Post post = Post.create(postId, "title", "content");
        postRepository.save(post);

        // when
        Post savedPost = postRepository.findById(postId);

        // then
        assertEquals(post, savedPost);
    }

    @DisplayName("PostRepository deleteAll 테스트")
    @Test
    void deleteAll() throws Exception {
        // given
        PostRepository postRepository = new PostRepository();

        Post post = Post.create(1L, "title", "content");
        postRepository.save(post);

        // when
        postRepository.deleteAll();

        // then
        assertThrows(Exception.class, () -> postRepository.findById(1L));
    }
}