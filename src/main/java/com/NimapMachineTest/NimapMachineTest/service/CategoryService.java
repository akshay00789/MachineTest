package com.NimapMachineTest.NimapMachineTest.service;

import com.NimapMachineTest.NimapMachineTest.entity.Category;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CategoryService {
    Page<Category> getCategories(int page);

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

}
