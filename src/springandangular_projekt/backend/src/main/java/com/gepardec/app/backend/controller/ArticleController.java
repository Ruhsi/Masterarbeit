package com.gepardec.app.backend.controller;

import com.gepardec.app.backend.article.Article;
import com.gepardec.app.backend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleControllerAPI {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController (final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ResponseEntity<List<Article>> getAllArticles () { return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK); }
}
