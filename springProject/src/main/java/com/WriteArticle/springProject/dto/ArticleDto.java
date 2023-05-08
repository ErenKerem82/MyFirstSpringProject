package com.WriteArticle.springProject.dto;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private String articleName;
    private String subject;
    private String desc;

    /*
    {
      "articleName": "test_be605e774852",
      "subject": "test_89c4aad80f0f",
      "desc": "test_c0a5d4536db4"
    }
     */
}
