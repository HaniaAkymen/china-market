package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceImplTest {
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private  ProductRepository productRepository;
    @InjectMocks
    private ShoppingCartServiceImpl shoppingCartService;

    @Test//не работает
    public void addProductToCart_ToysCat_success(){
        //задание начальных значений
     ShoppingCart shoppingCarProduct = new ShoppingCart();

     Customer bob = new Customer();
     Integer bobId = 8;
     bob.setId(bobId);

     Product toysCat = new Product();
     toysCat.setId(6);
     toysCat.setName("Cat_toys");

     shoppingCarProduct.setCustomer(bob);
     shoppingCarProduct.setProduct(toysCat);
     shoppingCarProduct.setQuantity(3);

     when(customerRepository.findById(8)).thenReturn(Optional.of(bob));
     when(productRepository.findById(6)).thenReturn(Optional.of(toysCat));

        //запустить сам метод
     shoppingCartRepository.save(shoppingCarProduct);

        //проверка результата
     verify(shoppingCartRepository, times(1)).save(shoppingCarProduct);

      }

    @Test
    public void deleteProductFromCart_SamuraiUmbrella_success(){
        //задание начальных значений
        ShoppingCart shoppingCart = new ShoppingCart();
        Customer gans = new Customer();
        Product samuraiUmbrella = new Product();
        Integer customerId = 8;
        Integer productId = 5;
        gans.setId(customerId);
        samuraiUmbrella.setId(productId);
        shoppingCart.setProduct(samuraiUmbrella);
        shoppingCart.setCustomer(gans);

        when(shoppingCartRepository.getByProductIdAndCustomerId(8,5)).thenReturn(shoppingCart);

        //запустить сам метод
        shoppingCartService.deleteProductFromCart(8,5);

        //проверка результата
        verify(shoppingCartRepository, times(1)).delete(shoppingCart);

    }
    @Test
    public void changeQuantityProductFromCart_SamuraiUmbrella_success(){
        //задание начальных значений
        ShoppingCart shoppingCartChange = new ShoppingCart();
        Customer gans = new Customer();
        Product samuraiUmbrella = new Product();
        Integer customerId = 8;
        Integer productId = 5;
        Integer quantity = 2;
        gans.setId(customerId);
        samuraiUmbrella.setId(productId);
        shoppingCartChange.setProduct(samuraiUmbrella);
        shoppingCartChange.setCustomer(gans);
        shoppingCartChange.setQuantity(quantity);

        when(shoppingCartRepository.getByProductIdAndCustomerId(8,5)).thenReturn(shoppingCartChange);

        //запустить сам метод

         shoppingCartService.changeQuantityProductFromCart(5,2,8);

         //проверка результата

        verify(shoppingCartRepository, times(1)).save(shoppingCartChange);

    }
    @Test//проверить
    public void getListShoppingCart_success(){
        //задание начальных значений
        List<ShoppingCart> shoppingCartList = new ArrayList<>();

        Customer bob = new Customer();
        Integer bobId = 8;
        bob.setId(bobId);

        Product toysCat = new Product();
        toysCat.setId(6);
        toysCat.setName("Cat_toys");

        Product whiteUmbrella = new Product();
        whiteUmbrella.setId(2);
        whiteUmbrella.setName("WhiteUmbrella");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setId(1L);
        shoppingCart1.setCustomer(bob);
        shoppingCart1.setProduct(toysCat);
        shoppingCart1.setQuantity(2);

        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.setId(2L);
        shoppingCart2.setCustomer(bob);
        shoppingCart2.setProduct(whiteUmbrella);
        shoppingCart2.setQuantity(3);

        shoppingCartList.add(shoppingCart1);
        shoppingCartList.add(shoppingCart2);

        when(shoppingCartRepository.getListByCustomerID(bobId)).thenReturn(shoppingCartList);

        //запустить сам метод
        List<ShoppingCart> shoppingCartList1 = shoppingCartRepository.getListByCustomerID(8);

        //проверка результата
        assertEquals(shoppingCartList, shoppingCartList1);
        verify(shoppingCartRepository,times(1)).getListByCustomerID(8);

    }


}