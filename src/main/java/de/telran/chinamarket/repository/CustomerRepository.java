package de.telran.chinamarket.repository;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM customer")
    List<Customer> getAllCustomers();

    @Query(nativeQuery = true, value = "SELECT * FROM customer WHERE status = :customer_status")
    List<Customer> findCustomerByStatus(@Param(value = "customer_status") String status);

}
