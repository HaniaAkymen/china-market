package de.telran.chinamarket.repository;
import de.telran.chinamarket.entity.ShopOrderProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOrderProductRepository extends JpaRepository<ShopOrderProduct, Integer> {
}
