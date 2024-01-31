package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;

import java.util.List;

public interface CustomerService {

    void saveCustomerByID(Customer customer);

    void setCustomerStatus(CustomerInfoStatus status, Integer id);

    Customer getCustomerById(Integer id);//перенести администратору

    List<Customer> getAllCustomers();

    List<Customer> getCustomersByStatus(String status); //сделать изменением парамметров?


}
