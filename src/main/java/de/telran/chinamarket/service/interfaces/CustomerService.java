package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.enums.CustomerInfoStatus;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(String firstName, String lastName, String email, String address, String phone);

    SecurityAccount saveSecurityAccount(Integer customerId, String customerEmail, String CustomerPassword);

    void setCustomerStatus(CustomerInfoStatus status, Integer id);

    Customer getCustomerById(Integer id);//перенести администратору

    List<Customer> getAllCustomers();

    List<Customer> getCustomersByStatus(String status); //сделать изменением парамметров?




}
