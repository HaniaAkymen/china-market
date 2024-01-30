package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.repository.CategoryRepository;
import de.telran.chinamarket.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
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



}
