package com.WriteArticle.springProject.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "/article")
public class Article {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "articleName")
    private String articleName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "desc")
    private String desc;



}
