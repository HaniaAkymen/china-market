package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.ShoppingCart;
import java.util.List;

/**
 * Interface for managing customer shopping carts.
 * Allows adding, deleting, and changing the quantity of products in the cart, as well as getting the list of products in the cart.
 * Интерфейс сервиса для управления корзинами покупок клиента.
 * Интерфейс позволяет добавлять, удалять и количество продуктов в корзине, а также получать список продуктов в корзине.
 * @author Hanna Akymenko
 * @version 1.0
 * @since 2024-01-28
 */
public interface ShoppingCartService {

    /**
     * Adds a product to the customer's shopping cart.
     * Добавляет продукт в корзину клиента.
     * @param productID ID of the product
     * @param quantity quantity of the product
     * @param customerID ID of the customer
     */
    void addProductToCart (Integer productID, Integer quantity, Integer customerID);

    /**
     * Deletes a product from the customer's shopping cart.
     * Удаляет продукт из корзины покупок клиента.
     * @param productID ID of the product
     * @param customerID ID of the customer
     */
    void deleteProductFromCart(Integer productID, Integer customerID);

    /**
     * Changes the quantity of a product in the customer's shopping cart.
     * Изменяет количество продуктов в корзине покупок клиента.
     * @param productID ID of the product
     * @param quantity quantity of the product
     * @param customerID ID of the customer
     */
    void changeQuantityProductFromCart(Integer productID, Integer quantity, Integer customerID);

    /**
     * Gets the list of products in the customer's shopping cart.
     * Получает список всех продуктов в корзине покупок клиента.
     * @param customerID ID of the customer
     * @return list of products in the cart
     */
    List<ShoppingCart> getListShoppingCart(Integer customerID);
}
