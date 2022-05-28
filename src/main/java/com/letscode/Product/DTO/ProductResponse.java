package com.letscode.Product.DTO;

import com.letscode.Product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String uuid;
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    public ProductResponse(Product product) {
        this.uuid = product.getUuid();
        this.nome = product.getNome();
        this.cpf = product.getCpf();
        this.email = product.getEmail();
        this.senha = product.getSenha();
    }

}
