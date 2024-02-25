package de.telran.chinamarket.dto;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import lombok.Data;

/**
 * DTO (Data Transfer Object) class representing a shop order.
 * Used for transferring order data between client and server.
 * This class holds information about an order, such as its payment type and delivery type.
 * DTO (Data Transfer Object) класс, представляющий заказ в магазине.
 * Используется для передачи данных о заказе между клиентом и сервером.
 * Этот класс содержит информацию о заказе, такую как тип оплаты и тип доставки.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
@Data
public class ShopOrderDTO {
    /**
     * The payment type of the order
     * Тип оплаты заказа
     */
    private PaymentType paymentType;

    /**
     * The delivery type of the order
     * Тип доставки заказа
     */
    private DeliveryType deliveryType;
}
