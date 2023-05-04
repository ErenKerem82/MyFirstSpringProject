package com.WriteArticle.springProject.service;

import com.WriteArticle.springProject.model.Article;
import com.WriteArticle.springProject.model.Category;
import com.WriteArticle.springProject.repository.ArticleRepository;
import com.WriteArticle.springProject.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category id Not Found  !!!"));
    }

    public Category createCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void updateArticle(Long id, Category categoryData) {
        Category oldCategory = getCategoryById(id);
        oldCategory.setName(categoryData.getName());
        oldCategory.setArticle(categoryData.getArticle());
        categoryRepository.save(oldCategory);
    }
}
