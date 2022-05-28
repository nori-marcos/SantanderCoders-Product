package com.letscode.Product.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotNull
    @Schema(description = "Nome do produto", example = "Geladeira")
    private String name;

    @NotNull
    @Schema(description = "Preço do produto", example = "2000")
    private BigDecimal price;

    @NotNull
    @Min(1)
    @Schema(description = "Quantidade de produtos para salvar no estoque", example = "1")
    private int quantity;

}
