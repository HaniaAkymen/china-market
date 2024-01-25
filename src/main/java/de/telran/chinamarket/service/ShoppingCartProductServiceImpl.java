package de.telran.chinamarket.service;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.entity.ShoppingCartProduct;
import de.telran.chinamarket.repository.ShoppingCartProductRepository;
import de.telran.chinamarket.repository.CustomerRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartProductServiceImpl implements ShoppingCartProductService{

    private final ShoppingCartProductRepository shoppingCartProductRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

   @Override
    public void addProductToCart (ShoppingCartProductDTO shoppingCartProductDTO) {
       System.out.println(shoppingCartProductDTO);

       ShoppingCartProduct shoppingCartProductEntity = new ShoppingCartProduct();
       shoppingCartProductEntity.setQuantity(shoppingCartProductDTO.getQuantity());

       Optional<Customer> customerOptional = customerRepository.findById(shoppingCartProductDTO.getCustomerID());
       if (!customerOptional.isPresent()) {
           throw new EntityNotFoundException("customer not found");
       }
       shoppingCartProductEntity.setCustomer(customerOptional.get());

       Optional<Product> productOptional = productRepository.findById(shoppingCartProductDTO.getProductID());
       if (!productOptional.isPresent()) {
           throw new EntityNotFoundException("product not found");
       }
       shoppingCartProductEntity.setProduct(productOptional.get());

       shoppingCartProductRepository.save(shoppingCartProductEntity);

   }

    @Override
    public void deleteProductFromCart(ShoppingCartProductDTO shoppingCartProductDTO) {

        System.out.println("----------------------------------------");
        System.out.println(shoppingCartProductDTO);

       ShoppingCartProduct shoppingCartProductToDelete = shoppingCartProductRepository.getByProductIdAndCustomerId(shoppingCartProductDTO.getCustomerID(), shoppingCartProductDTO.getProductID());

        System.out.println("----------------------------------------");
        System.out.println(shoppingCartProductToDelete);

       shoppingCartProductRepository.delete(shoppingCartProductToDelete);



    }
}
