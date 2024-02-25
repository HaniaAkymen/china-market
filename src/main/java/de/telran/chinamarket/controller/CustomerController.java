package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.CustomerDTO;
import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.service.interfaces.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/customer/get")
    public Customer getCustomer(@AuthenticationPrincipal UserDetails userDetails) {
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        Customer customer = customerService.getCustomerById(customerId);
        return customer;
    }
    @PostMapping(value = "/public/customer/add")
    @Operation(summary = "Создать нового пользователя", description = "Создает нового пользователя / измененяет пользователя при добавлении id в json")
    public void addNewCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer =  customerService.saveCustomer(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail(), customerDTO.getAddress(), customerDTO.getPhone());
        customerService.saveSecurityAccount(customer.getId(), customer.getEmail(), customerDTO.getPassword());
    }
}
