package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.service.interfaces.CategoryService;
import de.telran.chinamarket.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping(value = "/public/product/{id}")
    @Operation(summary = "Получить продукт", description = "Получить продукт по его ID")
    public Product getProductById(@PathVariable(value = "id") Integer id) {
        Product product = productService.getByID(id);
        return product;
    }
    @GetMapping(value = "/public/product/category/{id}")
    @Operation(summary = "Получить список продуктов категории", description = "Получает все продукты категории по ее ID")
    public List<Product> getProductsByCategory (@PathVariable(value = "id") Integer categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
