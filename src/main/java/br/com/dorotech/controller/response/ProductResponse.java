package br.com.dorotech.controller.response;

import java.math.BigDecimal;

import br.com.dorotech.service.domain.ProductDomain;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public static ProductResponse toProductResponse(ProductDomain domain) {
        return ProductResponse.builder()
            .amount(domain.getAmount())
            .price(domain.getPrice())
            .description(domain.getDescription())
            .name(domain.getName())
            .id(domain.getId())
            .build();
    }
}


