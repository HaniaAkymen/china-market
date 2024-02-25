package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.ShoppingCart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.telran.chinamarket.dto.ShoppingCartProductDTO;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM shopping_cart WHERE customer_id = :customer_id AND product_id = :product_id")
    ShoppingCart getByProductIdAndCustomerId(@Param(value = "customer_id") Integer customerID, @Param(value = "product_id") Integer productID);

    @Query(nativeQuery = true, value = "SELECT * FROM shopping_cart WHERE customer_id = :customer_id AND product_id = :product_id AND quantity = :quantity")
    ShoppingCart getByProductIdAndCustomerIdAndQuantity(@Param(value = "customer_id") Integer customerID, @Param(value = "product_id") Integer productID, @Param(value = "quantity") Integer quantity);

    @Query(nativeQuery = true, value = "SELECT * FROM shopping_cart WHERE customer_id = :customer_id")
    List<ShoppingCart> getListByCustomerID(@Param(value = "customer_id") Integer customerID);
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM shopping_cart WHERE customer_id = :customer_id")
    int deleteByCustomerID(@Param(value = "customer_id") Integer customerID);

}
