package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.enums.CustomerInfoStatus;

import java.util.List;

/**
 * Service interface for managing customers and their security accounts.
 * Интерфейс сервиса для управления клиентами и их счетами безопасности.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
public interface CustomerService {

    /**
     * Saves a new customer with the provided information.
     * Сохраняет нового клиента с предоставленной информацией.
     * Сохраняет нового клиента с предоставленной информацией.
     *
     * @param firstName the first name of the customer
     * @param lastName  the last name of the customer
     * @param email     the email address of the customer
     * @param address   the address of the customer
     * @param phone     the phone number of the customer
     * @return the saved customer
     */
    Customer saveCustomer(String firstName, String lastName, String email, String address, String phone);

    /**
     * Saves a new security account for the given customer.
     * Сохраняет новый счет безопасности для указанного клиента.
     * @param customerId the ID of the customer
     * @param customerEmail the email address of the customer (used as login)
     * @param CustomerPassword the password of the customer
     * @return the saved security account
     */
    SecurityAccount saveSecurityAccount(Integer customerId, String customerEmail, String CustomerPassword);

    /**
     * Sets the status of the customer with the specified ID.
     * Устанавливает статус клиента с указанным ID.
     * @param status the new status of the customer
     * @param id the ID of the customer
     */
    void setCustomerStatus(CustomerInfoStatus status, Integer id);

    /**
     * Retrieves a customer by their unique identifier.
     * Получает информацию о клиенте по его ID.
     * @param id the identifier of the customer to retrieve
     * @return the customer with the specified ID, or null if not found
     */
    Customer getCustomerById(Integer id);

    /**
     * Retrieves List all customers.
     * Получает список всех клиентов
     * @return a list of all customers
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieves List customers by their status.
     * Получает список клиентов по их статусу.
     * @param status the status of customers to retrieve
     * @return a list of customers with the specified status
     */
    List<Customer> getCustomersByStatus(String status);
}