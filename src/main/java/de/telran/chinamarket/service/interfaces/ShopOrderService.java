package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.enums.ShopOrderStatus;

import java.util.List;

public interface ShopOrderService {

    ShopOrder saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID);

    List<ShopOrder> getShopOrderList();

    ShopOrder getShopOrderById(Integer id);

    void setShopOrderStatus(ShopOrderStatus status, Integer id);


}
