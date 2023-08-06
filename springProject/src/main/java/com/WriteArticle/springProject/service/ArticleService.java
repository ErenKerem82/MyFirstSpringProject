package com.WriteArticle.springProject.service;
import com.WriteArticle.springProject.dto.ArticleDto;
import com.WriteArticle.springProject.repository.ArticleRepository;
import com.WriteArticle.springProject.model.Article;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    /*
    crud

    create -
    read -
    update -
    delete -

    map() --> -dönüştürmek- denilebilir
     */

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public List<ArticleDto> getAllArticle(){
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(article -> modelMapper.map(article,ArticleDto.class))
                .collect(Collectors.toList());
    }

    public ArticleDto getArticleById(Long id){
        Optional<Article> article = Optional.ofNullable(articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article id Not Found  !!!")));
        return modelMapper.map(article.get(),ArticleDto.class);
    }

    public ArticleDto createArticle(ArticleDto newArticle){
        Article article = modelMapper.map(newArticle,Article.class);
        return modelMapper.map(articleRepository.save(article),ArticleDto.class);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    public void updateArticle(Long id, ArticleDto articleData) {
        Optional<Article> oldArticle = articleRepository.findById(id);
        oldArticle.get().setAuthor(articleData.getAuthor());
        oldArticle.get().setArticleName(articleData.getArticleName());
        oldArticle.get().setDesc(articleData.getDesc());
        oldArticle.get().setSubject(articleData.getSubject());
        modelMapper.map(articleRepository.save(oldArticle.get()), ArticleDto.class);
    }

}
