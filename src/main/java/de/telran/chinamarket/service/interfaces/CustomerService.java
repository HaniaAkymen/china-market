package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;

import java.util.List;

public interface CustomerService {

    void saveCustomer(String firstName, String lastName, String email, String password, String address, String phone);

    void setCustomerStatus(CustomerInfoStatus status, Integer id);

    Customer getCustomerById(Integer id);//перенести администратору

    List<Customer> getAllCustomers();

    List<Customer> getCustomersByStatus(String status); //сделать изменением парамметров?




}
