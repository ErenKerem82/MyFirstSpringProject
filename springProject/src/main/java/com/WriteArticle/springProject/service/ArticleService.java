package com.WriteArticle.springProject.service;

import com.WriteArticle.springProject.repository.ArticleRepository;
import com.WriteArticle.springProject.model.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {

    /*
    crud

    create -
    read -
    update -
    delete -
     */

    private final ArticleRepository articleRepository;

    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article id Not Found  !!!"));
    }

    public Article createArticle(Article newArticle){
        return articleRepository.save(newArticle);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    public void updateArticle(Long id, Article articleData) {
        Article oldArticle = getArticleById(id);
        oldArticle.setArticleName(articleData.getArticleName());
        oldArticle.setSubject(articleData.getSubject());
        oldArticle.setDesc(articleData.getDesc());
        articleRepository.save(oldArticle);
    }

}
