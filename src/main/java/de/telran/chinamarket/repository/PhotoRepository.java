package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.Photo;
import de.telran.chinamarket.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    interface ShoppingCartProductRepository extends JpaRepository<ShoppingCart,Integer> {

    }
}
