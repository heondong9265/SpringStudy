package org.example.SpringBoot.service;

import org.example.SpringBoot.domain.Article;
import org.example.SpringBoot.dto.AddArticleRequest;
import org.example.SpringBoot.dto.UpdateArticleRequest;
import org.example.SpringBoot.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(BlogService.class)
class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @MockBean
    private BlogRepository blogRepository;

    @Test
    void findById() {

        // Given
        long articleId = 1;
        Article mockArticle = new Article("Mock Title", "Mock Content");
        when(blogRepository.findById(articleId)).thenReturn(java.util.Optional.of(mockArticle));

        // When
        Article result = blogService.findById(articleId);

        // Then
        assertThat(result).isEqualTo(mockArticle);
    }

    @Test
    void findAll() {

        // Given
        List<Article> mockArticles = List.of(
                new Article("제목 1", "내용 1"),
                new Article("제목 2", "내용 2")
        );
        when(blogRepository.findAll()).thenReturn(mockArticles);

        // When
        List<Article> result = blogService.findAll();

        // Then
        assertThat(result).isEqualTo(mockArticles);
    }

    @Test
    void save() {

        // Given
        AddArticleRequest addArticleRequest = new AddArticleRequest("제목", "내용");
        Article mockArticle = addArticleRequest.toEntity();
        when(blogRepository.save(any(Article.class))).thenReturn(mockArticle);

        // When
        Article result = blogService.save(addArticleRequest);

        // Then
        assertThat(result).isEqualTo(mockArticle);
    }

    @Test
    void delete() {

        // Given
        long articleId = 1;

        // When
        blogService.delete(articleId);

        // Then
        List<Article> articlesAfterDeletion = blogRepository.findAll();
        assertThat(articlesAfterDeletion).hasSize(0);
    }

    @Test
    void update() {

        // Given
        long articleId = 1;
        UpdateArticleRequest updateArticleRequest = new UpdateArticleRequest("수정 제목", "수정 내용");
        Article mockArticle = new Article("원본 제목", "원본 내용");
        when(blogRepository.findById(articleId)).thenReturn(java.util.Optional.of(mockArticle));

        // When
        Article result = blogService.update(articleId, updateArticleRequest);

        // Then
        assertThat(result.getTitle()).isEqualTo(updateArticleRequest.getTitle());
        assertThat(result.getContent()).isEqualTo(updateArticleRequest.getContent());
    }
}
