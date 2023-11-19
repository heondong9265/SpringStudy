package org.example.SpringBoot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.SpringBoot.domain.Article;
import org.example.SpringBoot.dto.AddArticleRequest;
import org.example.SpringBoot.dto.UpdateArticleRequest;
import org.example.SpringBoot.repository.BlogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    public Article findById(long id) {
        return blogRepository.findById(id) // 엔티티를 조회하고, 없으면 예외 발생
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 삭제 메서드
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정 메서드
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
