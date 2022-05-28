package com.letscode.Product.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    private String nome;

    private BigDecimal price;

    private  int quantity;

}
