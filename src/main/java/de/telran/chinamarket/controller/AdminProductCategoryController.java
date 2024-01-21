package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.ProductCategory;
import de.telran.chinamarket.entity.ProductCategory;
import de.telran.chinamarket.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping(value = "/admin/product_category/save")
    public void saveProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.save(productCategory);

    }


}
