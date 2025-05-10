package br.com.dorotech.service;

import java.util.List;

import br.com.dorotech.service.domain.ProductDomain;

public interface ProductService {
    ProductDomain create(ProductDomain domain);
    ProductDomain getProduct(Long id);
    ProductDomain getByName(String name);
    List<ProductDomain> getProducts();
    void deleteById(Long id);
}
