package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.CategoryRepository;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.service.interfaces.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Override
    public Category getByID(Integer id){
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
    public List<Category> getAllRootCategorys() {
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


}
