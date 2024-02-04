package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.enums.UserRole;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.SecurityAccountRepository;
import de.telran.chinamarket.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final SecurityAccountRepository securityAccountRepository;

    @Transactional
    @Override
    public void saveCustomerByID(Customer customer) {
        if (customer == null) {
            return;
        }

        SecurityAccount securityAccount;

        if (customer.getId() == null) {
            securityAccount = new SecurityAccount();
        }
        else {
            securityAccount = securityAccountRepository.findByLogin(customer.getEmail());

        }

        securityAccount.setRole(UserRole.CUSTOMER);
        securityAccount.setLogin(customer.getEmail());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(customer.getPassword());

        securityAccount.setPassword(encodePassword);

        customer.setStatus(CustomerInfoStatus.ACTIVE);
        customer.setSecurityAccount(securityAccount);
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
    public void setCustomerStatus(CustomerInfoStatus status, Integer id) {

        Customer updateCustomer = getCustomerById(id);
        if (updateCustomer == null) {
            return;
        }
        updateCustomer.setStatus(status);

        customerRepository.save(updateCustomer);
    }


    @Transactional
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Transactional
    @Override
    public List<Customer> getCustomersByStatus(String status) {
        return customerRepository.findCustomerByStatus(status);
    }


}



