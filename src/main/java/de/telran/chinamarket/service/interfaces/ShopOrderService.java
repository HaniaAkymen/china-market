package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.entity.ShopOrder;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ShopOrderService {

    void saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID);

    List<ShopOrder> getShopOrderList();


}
