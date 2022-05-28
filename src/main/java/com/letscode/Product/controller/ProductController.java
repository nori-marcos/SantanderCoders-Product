package com.letscode.Product.controller;

import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;
import com.letscode.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse registerProduct(@RequestBody ProductRequest productRequest) {
        return productService.registerProduct(productRequest);
    }

    @GetMapping("/{uuid}")
    public ProductResponse findProductByUuid(@PathVariable("uuid") String uuid) {
        return productService.findProductByUuid(uuid);
    }

    @GetMapping
    public List<ProductResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    @DeleteMapping("/{uuid}")
    public void deleteProduct(@PathVariable("uuid") String uuid) {
        productService.deleteProductByUuid(uuid);
    }

}
