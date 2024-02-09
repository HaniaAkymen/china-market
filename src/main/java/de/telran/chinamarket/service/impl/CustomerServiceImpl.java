package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.repository.SecurityAccountRepository;
import de.telran.chinamarket.service.interfaces.CustomerService;
import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.enums.UserRole;
import de.telran.chinamarket.repository.CustomerRepository;
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
    public void saveCustomer(String firstName, String lastName, String email, String password, String address, String phone) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setStatus(CustomerInfoStatus.ACTIVE);
        customerRepository.save(customer);


        SecurityAccount securityAccount = new SecurityAccount();
        securityAccount.setCustomerId(customer.getId());
        securityAccount.setLogin(customer.getEmail());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        securityAccount.setPassword(encodePassword);

        securityAccount.setRole(UserRole.CUSTOMER);
        securityAccountRepository.save(securityAccount);


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



