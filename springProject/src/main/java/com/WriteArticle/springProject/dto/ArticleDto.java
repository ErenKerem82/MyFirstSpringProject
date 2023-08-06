package com.WriteArticle.springProject.dto;
import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String author;
    private String articleName;
    private String subject;
    private String desc;

    /*
        {
      "id": 0,
      "author": "",
      "articleName": "",
      "subject": "",
      "desc": ""
    }
     */


}
