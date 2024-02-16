package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.service.interfaces.ShopOrderService;
import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.entity.ShopOrderProduct;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.enums.ShopOrderStatus;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.ShopOrderRepository;
import de.telran.chinamarket.repository.ShoppingCartRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public ShopOrder saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID) {

        ShopOrder shopOrder = new ShopOrder(); //создание нового пустого заказа
        shopOrder.setPaymentType(paymentType); //клиент передает тип оплаты в заказ
        shopOrder.setDeliveryType(deliveryType); //клиент передает тип доставки в заказ
        shopOrder.setStatus(ShopOrderStatus.ACTIVE); //при создании заказа, автоматически присваивается статус-Активный

        Optional<Customer> customerOptional = customerRepository.findById(customerID);//вытаскиваем клиента по его ID
        if (!customerOptional.isPresent()) {
            throw new EntityNotFoundException("Сustomer not found");
        }
        shopOrder.setCustomer(customerOptional.get()); //установка клиента для данного заказа
        fillShopOrderProductList(shopOrder);//заполняет список товаров в заказе
        shopOrderRepository.save(shopOrder);//сохраняем в базу заказ со всем списком товаров
        shoppingCartRepository.deleteByCustomerID(customerID);//очищаем корзину
        return shopOrder;
    }
    //Добавление списка товаров в заказ

    private void fillShopOrderProductList(ShopOrder shopOrder) {
        //в отдельный сервис
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.getListByCustomerID(shopOrder.getCustomer().getId());//получаем список товаров в корзине определенного клиента
        List<ShopOrderProduct> shopOrderProductList = new ArrayList<>();//создаем пустой список товаров в заказе
        Integer totalQuantity = 0;//создаем переменную всего товаров в заказе

        for (ShoppingCart shoppingCart : shoppingCartList) {//перебираем все продукты в корзине по одному
            ShopOrderProduct shopOrderProduct = new ShopOrderProduct();//для каждого продукта из корзины создаем новый товар в заказе

            shopOrderProduct.setProduct(shoppingCart.getProduct());//заполняем продукт
            shopOrderProduct.setQuantity(shoppingCart.getQuantity());//заполняем количество
            shopOrderProduct.setShopOrder(shopOrder);//заполняем заказ

            shopOrderProductList.add(shopOrderProduct);//Добавляем новый элемент в список товаров в Заказе

            totalQuantity += shopOrderProduct.getQuantity();;//добавляем кол-во одного продукта в переменную
        }
        shopOrder.setShopOrderProducts(shopOrderProductList);//!!!сохраняем список товаров в заказе
        shopOrder.setTotalQuantity(totalQuantity);//сохраняем общее количество товаров в заказ
    }

    @Transactional
    @Override
    public List<ShopOrder> getShopOrderList() {

        return shopOrderRepository.findAll();
    }

    @Transactional
    @Override
    public ShopOrder getShopOrderById(Integer id) {
        Optional<ShopOrder> optionalShopOrder = shopOrderRepository.findById(id);
        if (optionalShopOrder.isPresent()) {
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
