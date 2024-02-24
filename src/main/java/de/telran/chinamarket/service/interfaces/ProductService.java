package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Product;
import java.util.List;

/**
 * Service interface for managing products.
 * Интерфейс сервиса для управления продуктами.
 * @author Hanna Akymenko
 * @version 1.0
 * @since 2024-01-28
 */
public interface ProductService {

    /**
     * Retrieves a product by its ID.
     * Получает продукт по его ID.
     * @param id ID of the product
     * @return the product object
     */
    Product getByID(Integer id);

    /**
     * Sets a product's status to inactive.
     * Устанавливает статус продукта как неактивный.
     * @param id ID of the product
     */
    void inactiveById(Integer id);

    /**
     * Sets a product's status to active.
     * Устанавливает статус продукта как активный.
     * @param id ID of the product
     */
    void activeById(Integer id);

    /**
     * Saves a product.
     * Сохраняет продукт.
     * @param product the product to save
     */
    void save (Product product);

    /**
     * Retrieves List products by category ID.
     * Получает список продуктов по ID категории.
     * @param categoryId ID of the category
     * @return List of products in the category
     */
    List<Product> getProductsByCategoryId(Integer categoryId);

    /**
     * Retrieves List all products.
     * Получает список всех продуктов.
     * @return List of all products
     */
    List<Product> getAllProducts();
}
