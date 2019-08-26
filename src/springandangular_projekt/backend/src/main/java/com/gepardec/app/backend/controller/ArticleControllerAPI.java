package com.gepardec.app.backend.controller;

import com.gepardec.app.backend.article.Article;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface ArticleControllerAPI {

    @CrossOrigin
    @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    ResponseEntity<List<Article>> getAllArticles ();
}
