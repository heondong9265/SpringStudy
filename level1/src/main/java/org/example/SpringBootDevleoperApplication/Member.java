package org.example.SpringBootDevleoperApplication;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // (1) 엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // (2) 기본 생성자
@AllArgsConstructor
public class Member {
    @Id // (3) id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (4) 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id; // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false) // (5) name이라는 not null 컬럼과 매핑
    private String name; // DB 테이블의 'name' 컬럼과 매칭
}