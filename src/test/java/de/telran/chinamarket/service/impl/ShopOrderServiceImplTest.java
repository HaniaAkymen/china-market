package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.*;
import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.enums.ShopOrderStatus;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.ShopOrderRepository;
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
class ShopOrderServiceImplTest {
    @Mock
    private ShopOrderRepository shopOrderRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @InjectMocks
    private ShopOrderServiceImpl shopOrderService;

    @Test
    public void saveOrder_success(){
        PaymentType paypal = PaymentType.PAYPAL;
        DeliveryType courier = DeliveryType.COURIER;
        Customer bob = new Customer();
        Integer bobId = 8;
        bob.setId(bobId);

        List<ShoppingCart> shoppingCartList = new ArrayList<>();

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
        when(customerRepository.findById(8)).thenReturn(Optional.of(bob));
        when(shoppingCartRepository.getListByCustomerID(bobId)).thenReturn(shoppingCartList);

        ShopOrder shopOrder1 = shopOrderService.saveOrder(paypal, courier, bobId);

        assertEquals(shopOrder1.getPaymentType(), paypal);
        assertEquals(shopOrder1.getDeliveryType(), courier);
        assertEquals(shopOrder1.getCustomer(), bob);
        assertEquals(shopOrder1.getTotalQuantity(),5);
        assertEquals(shopOrder1.getStatus(), ShopOrderStatus.ACTIVE );
        assertEquals(shopOrder1.getShopOrderProducts().get(0).getProduct(), toysCat);
        assertEquals(shopOrder1.getShopOrderProducts().get(0).getQuantity(), 2);
        assertEquals(shopOrder1.getShopOrderProducts().get(1).getProduct(), whiteUmbrella);
        assertEquals(shopOrder1.getShopOrderProducts().get(1).getQuantity(),3);

        verify(shoppingCartRepository, times(1)).deleteByCustomerID(8);
    }

    @Test //проверить
    public void getShopOrderList_success() {
        List<ShopOrder> shopOrderList = new ArrayList<>();

        ShopOrder shopOrder1 = new ShopOrder();
        ShopOrder shopOrder2 = new ShopOrder();
        ShopOrder shopOrder3= new ShopOrder();

        shopOrderList.add(shopOrder1);
        shopOrderList.add(shopOrder2);
        shopOrderList.add(shopOrder3);
        when(shopOrderRepository.findAll()).thenReturn(shopOrderList);

        List<ShopOrder> shopOrderList1 = shopOrderService.getShopOrderList();

        assertEquals(shopOrderList, shopOrderList1);
        verify(shopOrderRepository, times(1)).findAll();
    }

    @Test //проверить
    public void getShopOrderById_success() {
        ShopOrder shopOrder1 = new ShopOrder();
        shopOrder1.setId(8L);

        when(shopOrderRepository.findById(8)).thenReturn(Optional.of(shopOrder1));

        ShopOrder shopOrder2 = shopOrderService.getShopOrderById(8);

        assertEquals(shopOrder1, shopOrder2);
        verify(shopOrderRepository, times(1)).findById(8);
    }

    @Test // проверить
    public void setShopOrderStatus_success() {
        ShopOrder shopOrder1 = new ShopOrder();
        shopOrder1.setId(8L);
        ShopOrderStatus newStatus = ShopOrderStatus.PAID;

        when(shopOrderRepository.findById(8)).thenReturn(Optional.of(shopOrder1));

        shopOrderService.setShopOrderStatus(newStatus,8);

        verify(shopOrderRepository, times(1)).save(shopOrder1);
    }
}