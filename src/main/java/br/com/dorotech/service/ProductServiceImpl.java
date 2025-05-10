package br.com.dorotech.service;

import br.com.dorotech.model.ProductEntity;
import br.com.dorotech.repository.ProductRepository;
import br.com.dorotech.service.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ProductDomain create(ProductDomain domain) {
        var entity = this.productRepository.save(domain.createProductEntity());
        return  domain.toProductDomain(entity);
    }

    @Override
    public ProductDomain getProduct(Long id) {
       return ProductDomain.builder()
       .build().toProductDomain(this.productRepository.findById(id).get());

    }

    @Override
    public ProductDomain getByName (String name) {
        var entity = productRepository
                .findByName(name)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                'PRODUTO NÃO ENCONTRADO: ' + name
                        )
                );
        return ProductDomain.builder()
                .name(entity.getName())
                .description(entity.getDescription)
                .price(entity.getPrice)
                .amount(entity.getAmount)
                .build();
    }
}
