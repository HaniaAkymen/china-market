package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {

}
