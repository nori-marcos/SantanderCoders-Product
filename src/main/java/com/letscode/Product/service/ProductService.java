package com.letscode.Product.service;

import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse registerProduct(ProductRequest productRequest);

    List<ProductResponse> findAllProducts();

    ProductResponse findProductByUuid(String uuid);

    void deleteProductByUuid(String uuid);
}
