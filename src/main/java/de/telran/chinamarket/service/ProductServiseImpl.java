package de.telran.chinamarket.service;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            return null;
        }
    }

    @Override
    public void save(Product product) {
        if (product == null) {
            return;
        }

        productRepository.save(product);
    }

}
