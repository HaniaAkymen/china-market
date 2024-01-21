package de.telran.chinamarket.service;

import de.telran.chinamarket.entity.ProductCategory;
import de.telran.chinamarket.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public ProductCategory getByID(Integer id){
        Optional<ProductCategory> optional;
        optional = productCategoryRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void save(ProductCategory productCategory){
        if (productCategory == null) {
            return;
        }
        productCategoryRepository.save(productCategory);
    }


}
