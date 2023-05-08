package com.WriteArticle.springProject.dto;

import com.WriteArticle.springProject.model.Article;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private List<Article> article;
    private String name;

    /*
    {
      "article": [
        {
          "articleName": "test_7de46bafe476",
          "subject": "test_b66402edce6a",
          "desc": "test_554c2804cb0b"
        }
      ],
      "name": "test_f89846f56b8a"
    }
     */
}
