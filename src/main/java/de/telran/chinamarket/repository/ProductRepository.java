package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM product WHERE category_id = :category_id")
    List<Product> getProductsByCategoryId(@Param(value = "category_id")Integer categoryID );
}
