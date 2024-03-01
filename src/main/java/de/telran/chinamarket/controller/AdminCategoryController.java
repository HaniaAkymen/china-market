package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.service.interfaces.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/admin/category/save")
    @Operation(summary = "Cохранить новую категорию или изменить категорию", description = "Сохраняет новую категорию, представленную в теле запроса, или изменяет уже существующую категорию, при указании в Json ее ID")
    public void saveCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping(value = "/admin/category/delete/{id}")
    @Operation(summary = "Удалить пустую категорию", description = "Удаляет пустую категорию по ее ID")
    public void deleteEmptyCategory(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping(value = "/admin/category/get_all")
    @Operation(summary = "Получить список категорий", description = "Получает список всех категорий")
    public List<Category> getAllCategory() {
       return categoryService.findAll();
    }
}

