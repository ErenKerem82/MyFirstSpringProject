package com.WriteArticle.springProject.service;
import com.WriteArticle.springProject.dto.CategoryDto;
import com.WriteArticle.springProject.model.Category;
import com.WriteArticle.springProject.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public List<CategoryDto> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> modelMapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id){
        Optional<Category> category = Optional.ofNullable(categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category id Not Found  !!!")));
        return modelMapper.map(category.get(), CategoryDto.class);
    }

    public CategoryDto createCategory(CategoryDto newCategory){
        Category category = modelMapper.map(newCategory,Category.class);
        return modelMapper.map(categoryRepository.save(category),CategoryDto.class);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void updateArticle(Long id, CategoryDto categoryData) {
        Optional<Category> oldCategory = categoryRepository.findById(id);
        oldCategory.get().setArticle(categoryData.getArticle());
        oldCategory.get().setCategoryName(categoryData.getCategoryName());
        modelMapper.map(categoryRepository.save(oldCategory.get()), CategoryDto.class);
    }
}
