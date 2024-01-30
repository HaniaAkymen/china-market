package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM customer")
    List<Customer> getAllCustomers();

    List<Customer> findCustomerByStatus(CustomerInfoStatus customerInfoStatus);

}
