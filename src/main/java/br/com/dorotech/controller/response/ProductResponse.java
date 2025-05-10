package br.com.dorotech.controller.response;

import br.com.dorotech.service.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public static ProductResponse from(ProductDomain d) {
        return new ProductResponse(
                d.getName(),
                d.getDescription(),
                d.getPrice(),
                d.getAmount()
        );
    }
}
