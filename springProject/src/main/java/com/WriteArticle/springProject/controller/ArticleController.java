package com.WriteArticle.springProject.controller;

import com.WriteArticle.springProject.service.ArticleService;
import com.WriteArticle.springProject.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticle(){
        return new ResponseEntity<>(articleService.getAllArticle(),OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id){
        return new ResponseEntity<>(articleService.getArticleById(id),OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(OK);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article newArticle){
        return new ResponseEntity<>(articleService.createArticle(newArticle),CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleData){
        articleService.updateArticle(id, articleData);
        return new ResponseEntity<>(OK);
    }

}