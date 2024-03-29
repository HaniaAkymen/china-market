package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.enums.ProductStatus;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.service.interfaces.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing products.
 * Реализация сервиса для управления продуктами.
 * @author Hanna Akymenko
 * @version 1.0
 * @since 2024-01-28
 */
@Service
@RequiredArgsConstructor
public class ProductServiseImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Product getByID(Integer id){
        Optional<Product> optional = productRepository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new EntityNotFoundException("product " + id + " not found");
        }
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void inactiveById(Integer id) {
        Product product = getByID(id);
        if (product == null){
            return;
        }
        product.setStatus(ProductStatus.INACTIVE);
        productRepository.save(product);
    }

    @Override
    public void activeById(Integer id) {
        Product product = getByID(id);
        if (product == null){
            return;
        }
        product.setStatus(ProductStatus.ACTIVE);
        productRepository.save(product);
    }
    @Override
    public List<Product> getProductsByCategoryId(Integer categoryId) {
       return productRepository.getProductsByCategoryId(categoryId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
