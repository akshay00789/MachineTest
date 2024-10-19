package com.NimapMachineTest.NimapMachineTest.service;


import com.NimapMachineTest.NimapMachineTest.entity.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {
    Page<Product> getProducts(int page);

    Product createProduct(Product product);

   Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}
