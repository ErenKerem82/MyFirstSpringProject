package com.WriteArticle.springProject.controller;

import com.WriteArticle.springProject.dto.CategoryDto;
import com.WriteArticle.springProject.model.Article;
import com.WriteArticle.springProject.model.Category;
import com.WriteArticle.springProject.service.ArticleService;
import com.WriteArticle.springProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(),OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto newCategory){
        return new ResponseEntity<>(categoryService.createCategory(newCategory),CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryeData){
        categoryService.updateArticle(id, categoryeData);
        return new ResponseEntity<>(OK);
    }

}
