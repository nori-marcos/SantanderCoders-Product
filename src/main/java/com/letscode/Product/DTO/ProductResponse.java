package com.letscode.Product.DTO;

import com.letscode.Product.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductResponse {

    private String uuid;
    private String name;
    private BigDecimal price;
    private int quantity;
    public ProductResponse(Product product) {
        this.uuid = product.getUuid();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
    public static List<ProductResponse> toResponse (List<Product> productList){
        return productList.stream().map(ProductResponse::new).collect(Collectors.toList());
    }
}
