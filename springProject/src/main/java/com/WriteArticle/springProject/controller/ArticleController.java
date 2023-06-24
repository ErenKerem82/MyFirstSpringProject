package com.WriteArticle.springProject.controller;

import com.WriteArticle.springProject.dto.ArticleDto;
import com.WriteArticle.springProject.service.ArticleService;
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
    public ResponseEntity<List<ArticleDto>> getAllArticle(){
        return new ResponseEntity<>(articleService.getAllArticle(),OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        return new ResponseEntity<>(articleService.getArticleById(id),OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(OK);
    }

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto newArticle){
        return new ResponseEntity<>(articleService.createArticle(newArticle),CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleData){
        articleService.updateArticle(id, articleData);
        return new ResponseEntity<>(OK);
    }

}