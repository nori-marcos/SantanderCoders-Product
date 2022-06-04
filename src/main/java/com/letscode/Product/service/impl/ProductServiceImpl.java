package com.letscode.Product.service.impl;

import com.letscode.Product.DTO.CartListRequest;
import com.letscode.Product.DTO.ProductRequest;
import com.letscode.Product.DTO.ProductResponse;
import com.letscode.Product.model.Product;
import com.letscode.Product.repository.ProductRepository;
import com.letscode.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductResponse registerProduct(ProductRequest productRequest) {
    Product product = new Product(productRequest);
    Product savedProduct = productRepository.save(product);
    return new ProductResponse(savedProduct);
  }

  @Override
  public List<ProductResponse> findAllProducts() {

    List<Product> savedProducts = productRepository.findAll();

    return ProductResponse.toResponse(savedProducts);
  }

  @Override
  public ProductResponse findProductByUuid(String uuid) {

    Product savedProduct = productRepository.findByUuid(uuid);

    return new ProductResponse(savedProduct);
  }

  @Override
  public void deleteProductByUuid(String uuid) {

    Product savedProduct = productRepository.findByUuid(uuid);

    productRepository.delete(savedProduct);
  }

  @Override
  public ProductResponse getProductForSale(String uuid, int quantity) {

    Product product = productRepository.findByUuid(uuid);
    if (product.getQuantity() < quantity) {
      throw new RuntimeException(
          String.format("Existem somente %s produtos no estoque", product.getQuantity()));
    }

    return new ProductResponse(product, quantity);
  }

  @Override
  public void removeItemsFromInventory(CartListRequest productsFromSale) {
//    Product savedProduct = productRepository.findByUuid(cartRequest.);
//    int savedProductQuantity = savedProduct.getQuantity();
//    if (savedProductQuantity < quantity) {
//      throw new RuntimeException(
//          String.format("Existem somente %s produtos com nome %s no estoque", savedProduct.getQuantity(),
//              savedProduct.getName()));
//    }
//    log.info("Quantidade em estoque {}", savedProductQuantity);
//    log.info("Quantidade na venda: {}", quantity);
//    savedProduct.setQuantity(savedProductQuantity - quantity);
//    productRepository.save(savedProduct);

    productsFromSale.getProductsOfCart().forEach(
        product -> {
          String productUuid = product.getProductUuid();
          int productFromSaleQuantity = product.getQuantity();
          Product savedProduct = productRepository.findByUuid(productUuid);
          int savedProductQuantity = savedProduct.getQuantity();
          if (savedProductQuantity < productFromSaleQuantity) {
            throw new RuntimeException(
                String.format("Existem somente %s produtos com nome %s no estoque", savedProduct.getQuantity(),
                    savedProduct.getName()));
          }
          log.info("Quantidade em estoque {}", savedProductQuantity);
          log.info("Quantidade na venda: {}", productFromSaleQuantity);
          savedProduct.setQuantity(savedProductQuantity - productFromSaleQuantity);
          productRepository.save(savedProduct);
        });
  }
}
