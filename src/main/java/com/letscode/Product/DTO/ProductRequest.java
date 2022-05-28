package com.letscode.Product.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String nome;

    private String cpf;

    private String senha;

    private String email;
}
