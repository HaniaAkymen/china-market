package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @PostMapping(value = "/admin/product/save")
    public void saveProduct(@RequestBody Product product) {
        System.out.println(product.getName());

        productService.save(product);

    }
    @DeleteMapping(value = "/admin/product/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {

        productService.inactiveById(id);

    }


}
