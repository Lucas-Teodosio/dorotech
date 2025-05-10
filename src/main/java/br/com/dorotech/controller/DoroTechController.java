package br.com.dorotech.controller;

import br.com.dorotech.controller.request.ProductRequest;
import br.com.dorotech.controller.response.ResponseProduct;
import br.com.dorotech.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@Data
public class DoroTechController {
    private final ProductService productService;
    private List<ProductRequest> productRequestList  = new ArrayList<ProductRequest>();;

    @PostMapping
    public String create(@RequestBody  ProductRequest productRequest) {
       this.productService.create(productRequest.createProductDomain());
        return "product created with success";
    }

    @GetMapping
    public List<ProductRequest> list() {
        return this.productRequestList;
    }

    @DeleteMapping
    public String delete() {
        return "delete product";
    }

    @GetMapping("/id")
    public String getProductById(){
        return "get product by id";
    }

    @GetMapping
    public ResponseProduct getByName(@RequestParam("nome") String nome) {
        var domain = productService.getByName(nome);
        return ResponseProduct.from(domain);
    }
}
