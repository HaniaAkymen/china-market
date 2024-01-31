package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.entity.ShopOrderProduct;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.enums.ShopOrderStatus;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.ShopOrderRepository;
import de.telran.chinamarket.repository.ShoppingCartRepository;
import de.telran.chinamarket.service.interfaces.ShopOrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopOrderServiceImpl implements ShopOrderService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ShopOrderRepository shopOrderRepository;

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public void saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID){

        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setPaymentType(paymentType);
        shopOrder.setDeliveryType(deliveryType);
        shopOrder.setStatus(ShopOrderStatus.ACTIVE);

        Optional<Customer> customerOptional = customerRepository.findById(customerID);
        if (!customerOptional.isPresent()) {
            throw new EntityNotFoundException("customer not found");
        }
        shopOrder.setCustomer(customerOptional.get());

        List<ShoppingCart> shoppingCartList = shoppingCartRepository.getListByCustomerID(customerID);
        List<ShopOrderProduct> shopOrderProductList = new ArrayList<>();


        for (ShoppingCart shoppingCart: shoppingCartList){
            ShopOrderProduct shopOrderProduct = new ShopOrderProduct();
            shopOrderProduct.setProduct(shoppingCart.getProduct());
            shopOrderProduct.setQuantity(shoppingCart.getQuantity());
            shopOrderProduct.setShopOrder(shopOrder);

            shopOrderProductList.add(shopOrderProduct);
        }

        shopOrder.setShopOrderProducts(shopOrderProductList);

        shopOrderRepository.save(shopOrder);

        shoppingCartRepository.deleteByCustomerID(customerID);

    }

    @Transactional
    @Override

     public List<ShopOrder> getShopOrderList (){
        return shopOrderRepository.findAll();

    }

    @Transactional
    @Override
    public ShopOrder getShopOrderById(Integer id) {
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(id);
        if (optionalShopOrder.isPresent()){
            return optionalShopOrder.get();
        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public void setShopOrderStatus(ShopOrderStatus status, Integer id) {

        ShopOrder shopOrderById = getShopOrderById(id);
        if (shopOrderById == null) {
            return;
        }

        shopOrderById.setStatus(status);

        shopOrderRepository.save(shopOrderById);
    }








}
