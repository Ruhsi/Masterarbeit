package com.gepardec.app.backend.repository;

import com.gepardec.app.backend.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
