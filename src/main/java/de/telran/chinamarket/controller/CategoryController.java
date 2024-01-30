package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value= "/category/get_tree")
    public List<Category> getCategoryTree(){
        return categoryService.getAllRootCategorys();
    }




}
