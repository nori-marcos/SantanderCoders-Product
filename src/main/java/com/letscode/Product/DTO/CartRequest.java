package com.letscode.Product.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class CartRequest {
  private String productUuid;
  private int quantity;
}
