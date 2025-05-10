package br.com.dorotech.controller.response;

import br.com.dorotech.service.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ResponseProduct {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amount;

    public static ResponseProduct from(ProductDomain d) {
        return new ResponseProduct(
                d.getName(),
                d.getDescription(),
                d.getPrice(),
                d.getAmount()
        );
    }
}
