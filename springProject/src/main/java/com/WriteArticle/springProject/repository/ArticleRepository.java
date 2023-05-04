package com.WriteArticle.springProject.repository;

import com.WriteArticle.springProject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
