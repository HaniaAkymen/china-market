package de.telran.chinamarket.dto;

import lombok.Data;

/**
 * DTO (Data Transfer Object) class representing a product in a shopping cart.
 * Used for transferring product data between client and server.
 * This class holds information about a product in a shopping cart, such as its ID and quantity.
 * DTO (Data Transfer Object) класс, представляющий товар в корзине покупок.
 * Используется для передачи данных о товаре между клиентом и сервером.
 * Этот класс содержит информацию о товаре в корзине покупок, такую как его идентификатор и количество.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
@Data
public class ShoppingCartProductDTO {

    /**
     * The ID of the product
     * Идентификатор товара
     */
    private Integer productID;

    /**
     * The quantity of the product in the shopping cart
     * Количество товара в корзине покупок
     */
    private Integer quantity;
}
