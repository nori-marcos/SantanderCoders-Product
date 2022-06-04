package com.letscode.Product.controller;

import com.letscode.Product.DTO.CartListRequest;
import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;
import com.letscode.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse registerProduct(@RequestBody @Valid ProductRequest productRequest) {
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

    @GetMapping("/{uuid}/{quantity}")
    public ProductResponse getProductForSale(@PathVariable("uuid") String uuid, @PathVariable("quantity") int quantity) {
        return productService.getProductForSale(uuid, quantity);
    }

    /*@GetMapping("/remove/{productUuid}/{quantity}")
    public String removeItemsFromInventory (@PathVariable("productUuid") String productUuid,
                                          @PathVariable("quantity") int quantity) {
        productService.removeItemsFromInventory(productUuid, quantity);
        return "Removido com sucesso";
    }*/

    @PutMapping("/remove-items")
    public String removeItemsFromInventory(@RequestBody CartListRequest cartListRequest) {
        productService.removeItemsFromInventory(cartListRequest);
        return "Items successfully removed!";
    }

}
