package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @PostMapping(value = "/admin/product/save")
    @Operation(summary = "Сохранить новый продукт", description = "Сохраняет новый продукт,  представленный в теле запроса")
    public void saveProduct(@RequestBody Product product) {
       productService.save(product);
    }
    @PutMapping(value = "/admin/product/inactive/{id}")
    @Operation(summary = "Сделать продукт неактивным", description = "Изменить статус продукта на неактивный по его ID")
    public void inactiveProduct(@PathVariable Integer id) {
        productService.inactiveById(id);
    }
    @PutMapping(value = "/admin/product/active/{id}")
    @Operation(summary = "Сделать продукт активным", description = "Изменить статутс продукта на активный по его ID")
    public void activeProduct(@PathVariable Integer id) {
        productService.activeById(id);
    }
    @GetMapping(value = "/admin/get_product_list")
    @Operation(summary = "Получить список всех продуктов", description = "Получает список всех продуктов")
    public List<Product> getListProduct(){
       return productService.getAllProducts();
    }
}
