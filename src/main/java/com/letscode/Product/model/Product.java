package com.letscode.Product.model;

import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "quantidade")
    private int quantidade;


    public Product(ProductRequest productRequest){
        this.nome = productRequest.getNome();
        this.cpf = productRequest.getCpf();
        this.email = productRequest.getEmail();
        this.senha = productRequest.getSenha();
    }

}
