package org.example.SpringBoot.controller;

import lombok.RequiredArgsConstructor;
import org.example.SpringBoot.domain.Article;
import org.example.SpringBoot.dto.AddArticleRequest;
import org.example.SpringBoot.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST일 때, 전달 받은 URL와 동일하면 해당 메서드로 매핑
    @PostMapping("api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청 자원이 성공적으로 생성 되었다면, 저장된 블로그 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
