package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM category where parent_category_id is null")
    List<Category> getAllRootCategorys();





}

