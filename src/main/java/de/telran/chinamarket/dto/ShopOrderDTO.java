package de.telran.chinamarket.dto;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import lombok.Data;

@Data
public class ShopOrderDTO {

    private PaymentType paymentType;

    private DeliveryType deliveryType;

    private Integer customerID;


}
