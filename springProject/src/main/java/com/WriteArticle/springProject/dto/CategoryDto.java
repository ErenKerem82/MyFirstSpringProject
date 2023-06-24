package com.WriteArticle.springProject.dto;

import com.WriteArticle.springProject.model.Article;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private List<Article> article;
    private String categoryName;


    /*
        {
      "id": 0,
      "article": [
        {
          "id": 0,
          "author": "",
          "articleName": "",
          "subject": "",
          "desc": ""
        }
      ],
      "categoryName": ""
    }
     */

}
