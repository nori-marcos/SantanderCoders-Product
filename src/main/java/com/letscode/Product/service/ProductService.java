package com.letscode.Product.service;

import com.letscode.Product.DTO.CartListRequest;
import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    ProductResponse registerProduct(ProductRequest productRequest);

    List<ProductResponse> findAllProducts();

    ProductResponse findProductByUuid(String uuid);

    void deleteProductByUuid(String uuid);

    ProductResponse getProductForSale(String uuid, int quantity);

    void removeItemsFromInventory(CartListRequest cartListRequest);

}
