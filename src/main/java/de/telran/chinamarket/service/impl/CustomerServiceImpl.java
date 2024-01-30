package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * description
 *
 * @author Hanna Akymenko 28.01.2024.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public void saveCustomerByID(Customer customer) {
        if (customer == null) {
            return;
        }

        customer.setStatus(CustomerInfoStatus.ACTIVE);
        customerRepository.save(customer);

    }

    @Transactional
    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void updateCustomerById(Integer id) {

        Customer updateCustomer = getCustomerById(id);
        if (updateCustomer == null) {
            return;
        }
        updateCustomer.setId(id);

        /*    updateCustomer.setStatus(customerStatus -> {
                    switch (customerStatus) {
                        case ACTIVE:
                            updateCustomer.setStatus(CustomerInfoStatus.ACTIVE);
                            break;
                        case INACTIVE:
                            updateCustomer.setStatus(CustomerInfoStatus.INACTIVE);
                            break;
                        case BLOCKED:
                            updateCustomer.setStatus(CustomerInfoStatus.BLOCKED);
                            break;
                        default:
                    }
                }
        );*/

        updateCustomer.setStatus(CustomerInfoStatus.ACTIVE);
        updateCustomer.setStatus(CustomerInfoStatus.INACTIVE);
        updateCustomer.setStatus(CustomerInfoStatus.BLOCKED);

        customerRepository.save(updateCustomer);
    }


    @Transactional
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Transactional
    @Override
    public List<Customer> getCustomersByStatus(CustomerInfoStatus status) {
        return customerRepository.findCustomerByStatus(status);
    }


}



