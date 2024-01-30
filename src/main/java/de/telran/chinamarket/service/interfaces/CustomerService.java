package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    void saveCustomerByID(Customer customer);

    Customer getCustomerById(Integer id);

    void updateCustomerById(Integer id);

    List<Customer> getAllCustomers();

//    void ChangeInfoStatusById(Integer id);

    List<Customer> getCustomersByStatus(CustomerInfoStatus status);


}
