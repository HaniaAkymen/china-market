package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id) {
        Product product = productService.getByID(id);
        return product;

    }




}
