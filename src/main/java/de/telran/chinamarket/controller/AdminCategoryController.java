package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/admin/category/save")
    public void saveCategory(@RequestBody Category category) {
        categoryService.save(category);

    }



}
