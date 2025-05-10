package br.com.dorotech.controller.request;

import br.com.dorotech.service.domain.ProductDomain;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest implements Serializable {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public ProductDomain createProductDomain() {
        return ProductDomain.builder()
                .name(this.name)
                .description(this.description)
                .amount(this.amount)
                .price(this.price)
                .build();
    }
}

