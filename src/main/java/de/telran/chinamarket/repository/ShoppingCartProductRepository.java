package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM shopping_cart_product WHERE customer_id = :customer_id AND product_id = :product_id")
    ShoppingCartProduct getByProductIdAndCustomerId(@Param(value = "customer_id") Integer customerID, @Param(value = "product_id") Integer productID);

}
