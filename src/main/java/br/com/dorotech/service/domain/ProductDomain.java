package br.com.dorotech.service.domain;

import br.com.dorotech.model.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductDomain {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public ProductEntity createProductEntity() {
        return ProductEntity.builder()
                .name(this.name)
                .description(this.description)
                .amount(this.amount)
                .price(this.price)
                .build();
    }

    public ProductDomain toProductDomain(ProductEntity entity){
        return ProductDomain.builder()
            .id(entity.getId())
                .price(entity.getPrice())
                .amount(entity.getAmount())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
