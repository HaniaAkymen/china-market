package de.telran.chinamarket.service;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import org.springframework.web.bind.annotation.PostMapping;

public interface ShopOrderService {

    void saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID);


}
