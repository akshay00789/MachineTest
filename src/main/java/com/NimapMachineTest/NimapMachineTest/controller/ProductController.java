package com.NimapMachineTest.NimapMachineTest.controller;


import com.NimapMachineTest.NimapMachineTest.dto.BaseResponse;
import com.NimapMachineTest.NimapMachineTest.entity.Product;
import com.NimapMachineTest.NimapMachineTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<BaseResponse<Page<Product>>> getProducts(@RequestParam(defaultValue = "0") int page) {
        Page<Product> products = productService.getProducts(page);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Products fetched successfully", products));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Product>> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "Product created successfully", createdProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Product>> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Product fetched successfully", product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Product updated successfully", updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Product deleted successfully"));
    }

}
