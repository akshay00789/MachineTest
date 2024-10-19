package com.NimapMachineTest.NimapMachineTest.service.impl;

import com.NimapMachineTest.NimapMachineTest.Exception.ProductNotFoundException;
import com.NimapMachineTest.NimapMachineTest.entity.Product;
import com.NimapMachineTest.NimapMachineTest.repository.ProductRepository;
import com.NimapMachineTest.NimapMachineTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProducts(int page) {
        Pageable pageable = PageRequest.of(page, 10);  // 10 is the page size
        return productRepository.findAll(pageable);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
