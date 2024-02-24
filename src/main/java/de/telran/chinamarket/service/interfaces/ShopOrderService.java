package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.enums.ShopOrderStatus;

import java.util.List;

/**
 * Service interface for managing shop orders.
 * Интерфейс сервиса для управления заказами магазина.
 * @author Hanna Akymenko
 * @version 1.0
 * @since 2024-01-28
 */
public interface ShopOrderService {
    /**
     * Saves a new order with the specified payment and delivery types for the given customer.
     * Сохраняет новый заказ с указанными типами оплаты и доставки для заданного клиента.
     * @param paymentType the payment type for the order
     * @param deliveryType the delivery type for the order
     * @param customerID the ID of the customer placing the order
     * @return the saved shop order object
     */
    ShopOrder saveOrder(PaymentType paymentType, DeliveryType deliveryType, Integer customerID);

    /**
     * Retrieves a list of all shop orders.
     * Получает список всех заказов магазина.
     * @return List of shop orders
     */
    List<ShopOrder> getShopOrderList();

    /**
     * Retrieves a shop order by its ID.
     * Получает заказ магазина по его ID.
     * @param id the ID of the shop order
     * @return the shop order object, or null if not found
     */
    ShopOrder getShopOrderById(Integer id);

    /**
     * Sets the status of a shop order with the specified ID.
     * Устанавливает статус заказа магазина с указанным ID.
     * @param status the status to set
     * @param id the ID of the shop order
     */
    void setShopOrderStatus(ShopOrderStatus status, Integer id);
}
