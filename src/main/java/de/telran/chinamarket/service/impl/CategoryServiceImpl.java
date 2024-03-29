package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.CategoryRepository;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CategoryService interface for managing categories.
 * Реализация интерфейса CategoryService для управления категориями.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public Category getByID(Integer id) {
        Optional<Category> optional;
        optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        } else {
            return null;
        }
    }
    @Override
    public void save(Category category){
        if (category == null) {
            return;
        }
        categoryRepository.save(category);
    }
    @Override
    public List<Category> getAllRootCategories() {
        return categoryRepository.getAllRootCategorys();
    }
    @Override
    public void deleteCategory(Integer id) {
            Category categoryDEl = getByID(id);

            List<Product> productList = productRepository.getProductsByCategoryId(id);
            if (!productList.isEmpty()) {
                throw new RuntimeException("category not empty");

            } else {
                categoryRepository.delete(categoryDEl);
        }
    }
    @Override
    public  List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
