package org.example.SpringBoot.repository;

import org.example.SpringBoot.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
