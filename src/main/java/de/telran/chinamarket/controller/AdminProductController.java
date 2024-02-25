package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @PostMapping(value = "/admin/product/save")
    public void saveProduct(@RequestBody Product product) {
       productService.save(product);
    }
    @PutMapping(value = "/admin/product/inactive/{id}")
    public void inactiveProduct(@PathVariable Integer id) {
        productService.inactiveById(id);
    }

    @PutMapping(value = "/admin/product/active/{id}")
    public void activeProduct(@PathVariable Integer id) {
        productService.activeById(id);
    }

    @GetMapping(value = "/admin/get_product_list" )
    public List<Product> getListProduct(){
       return productService.getAllProducts();
    }
}
