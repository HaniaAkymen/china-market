package de.telran.chinamarket.service;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.repository.ShoppingCartRepository;
import de.telran.chinamarket.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void addProductToCart(Integer productID, Integer quantity, Integer customerID) {

        ShoppingCart shoppingCartEntity = new ShoppingCart();
        shoppingCartEntity.setQuantity(quantity);

        Optional<Customer> customerOptional = customerRepository.findById(customerID);
        if (!customerOptional.isPresent()) {
            throw new EntityNotFoundException("customer not found");
        }
        shoppingCartEntity.setCustomer(customerOptional.get());

        Optional<Product> productOptional = productRepository.findById(productID);
        if (!productOptional.isPresent()) {
            throw new EntityNotFoundException("product not found");
        }
        shoppingCartEntity.setProduct(productOptional.get());

        shoppingCartRepository.save(shoppingCartEntity);

    }


    @Transactional
    @Override
    public void deleteProductFromCart(Integer productID, Integer quantity, Integer customerID) {

        ShoppingCart shoppingCartToDelete = shoppingCartRepository.getByProductIdAndCustomerId(customerID, productID);

        System.out.println("----------------------------------------");
        System.out.println(shoppingCartToDelete);

        shoppingCartRepository.delete(shoppingCartToDelete);


    }
    @Transactional
    @Override
    public void changeQuantityProductFromCart(Integer productID, Integer quantity, Integer customerID) {


        ShoppingCart shoppingCartProductChange = shoppingCartRepository.getByProductIdAndCustomerId(customerID, productID);

        if (shoppingCartProductChange != null) {
            shoppingCartProductChange.setQuantity(quantity);
            shoppingCartRepository.save(shoppingCartProductChange);
        } else {
            throw new EntityNotFoundException("product not found");
        }


    }
}
