package org.example.SpringBoot.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정
@Getter // Getter 메서드 대체
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id // 기본키 : id 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가, MySQL의 AUTO_INCREMENT
    @Column(name = "id", updatable = false) // 한번 저장된 후 수정 불가능 (영속화)
    private Long id;

    @Column(name = "title", nullable = false) // title은 not null로 지정
    private String title;

    @Column(name = "content", nullable = false) // name도 not null로 지정
    private  String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 블로그 글 수정 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
