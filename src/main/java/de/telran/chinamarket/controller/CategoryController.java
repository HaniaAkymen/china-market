package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.service.interfaces.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value= "/public/category/{id}")
    @Operation(summary = "Получить категорию", description = "Получает категорию по ее ID")
    public Category getCategoryByID(@PathVariable(name = "id") Integer id){
       return categoryService.getByID(id);
    }

    @GetMapping(value= "/public/category/get_tree")
    @Operation(summary = "Получить дерево категорий", description = "Получает все категории с их подкатегориями")
    public List<Category> getCategoryTree(){
        return categoryService.getAllRootCategories();
    }
}
