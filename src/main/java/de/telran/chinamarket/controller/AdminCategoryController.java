package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/admin/category/save")
    public void saveCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping(value = "/admin/category/delete/{id}")
    public void deleteEmptyCategory(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping(value = "/admin/category/get_all")
    public List<Category> getAllCategory() {
       return categoryService.findAll();
    }
}

