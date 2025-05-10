package br.com.dorotech.service;

import br.com.dorotech.model.ProductEntity;
import br.com.dorotech.repository.ProductRepository;
import br.com.dorotech.service.domain.ProductDomain;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDomain create(ProductDomain domain) {
        var entity = this.productRepository.save(domain.createProductEntity());
        return domain.toProductDomain(entity);
    }

    @Override
    public ProductDomain getProduct(Long id) {
        return ProductDomain.builder()
                .build().toProductDomain(this.productRepository.findById(id).get());

    }

    @Override
    public ProductDomain getByName(String name) {
        return ProductDomain.builder()
                .build().toProductDomain(this.productRepository.findByName(name).get());
    }

    @Override
    public List<ProductDomain> getProducts() {
       return this.productRepository.findAll().stream()
       .map(it -> ProductDomain.builder().build().toProductDomain(it)).toList();
    }

    @Override
    public void deleteById(Long id) {
        var product = this.productRepository.findById(id);
        if (product.isPresent()) {
            this.productRepository.delete(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }
}
