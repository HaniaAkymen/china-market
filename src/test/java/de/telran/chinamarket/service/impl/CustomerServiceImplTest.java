package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.enums.UserRole;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.SecurityAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private SecurityAccountRepository securityAccountRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void saveCustomer_bob_success() {

        Customer bob = new Customer();
        bob.setFirstName("Bob");
        bob.setLastName("Konig");
        bob.setEmail("bob1983@gmail.com");
        bob.setAddress("Berlin");
        bob.setPhone("01767657889");
        bob.setStatus(CustomerInfoStatus.ACTIVE);

        Customer viktor = customerService.saveCustomer("Bob", "Konig", "bob1983@gmail.com", "Berlin", "01767657889");
        assertEquals(bob, viktor);

        verify(customerRepository, times(1)).save(bob);
    }
    @Test
    public void saveSecurityAccount_success(){

        SecurityAccount securityAccount2 = customerService.saveSecurityAccount(2, "bob1983@gmail.com", "6387646gjhgjh");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertThat(encoder.matches("6387646gjhgjh", securityAccount2.getPassword())).isTrue();

        assertEquals("bob1983@gmail.com", securityAccount2.getLogin());
        assertEquals(2, securityAccount2.getCustomerId());
        assertEquals(UserRole.CUSTOMER, securityAccount2.getRole());

    }
    @Test
    public void getCustomerById_success() {
        Customer bob = new Customer();
        bob.setFirstName("Bob");
        bob.setId(7);

        when(customerRepository.findById(7)).thenReturn(Optional.of(bob));
        Customer bob2 = customerService.getCustomerById(7);
        assertEquals(bob, bob2);
        verify(customerRepository, times(1)).findById(7);
    }

    @Test
    public void setCustomerStatus_success() {

    }


    @Test
    public void getAllCustomers_success() {
        List<Customer> customerList = new ArrayList<>();
        Customer gans = new Customer();
        gans.setId(6);
        Customer bob = new Customer();
        bob.setId(7);
        Customer kira = new Customer();
        kira.setId(8);
        customerList.add(gans);
        customerList.add(bob);
        customerList.add(kira);

        when(customerRepository.getAllCustomers()).thenReturn(customerList);
        List<Customer> customerList1 = customerService.getAllCustomers();
        assertEquals(customerList, customerList1);
        verify(customerRepository, times(1)).getAllCustomers();
    }
   /* @Test
    public void getCustomersByStatus_success() {
        List<Customer> customerList = new ArrayList<>();
        Customer gans = new Customer();
        gans.setId(6);
        gans.setStatus(CustomerInfoStatus.ACTIVE);
        Customer bob = new Customer();
        bob.setId(7);
        bob.setStatus(CustomerInfoStatus.ACTIVE);
        Customer kira = new Customer();
        kira.setId(8);
        kira.setStatus(CustomerInfoStatus.ACTIVE);

        customerList.add(gans);
        customerList.add(bob);
        customerList.add(kira);

        when(customerRepository.findCustomerByStatus()).thenReturn(customerList);
        List<Customer> customerList1 = customerService.getCustomersByStatus();
        assertEquals(customerList, customerList1);
        verify(customerRepository, times(1)).findCustomerByStatus();

    }*/
}