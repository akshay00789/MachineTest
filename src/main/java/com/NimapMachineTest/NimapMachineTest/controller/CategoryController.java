package com.NimapMachineTest.NimapMachineTest.controller;

import com.NimapMachineTest.NimapMachineTest.dto.BaseResponse;
import com.NimapMachineTest.NimapMachineTest.entity.Category;
import com.NimapMachineTest.NimapMachineTest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<BaseResponse<Page<Category>>> getCategories(@RequestParam(defaultValue = "0") int page) {
        Page<Category> categories = categoryService.getCategories(page);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Categories fetched successfully", categories));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Category>> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "Category created successfully", createdCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Category>> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Category fetched successfully", category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Category>> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Category updated successfully", updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Category deleted successfully"));
    }

}
