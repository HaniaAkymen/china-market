package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/customer/{id}")
    public Customer getCustomer(@PathVariable(value = "id") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }
    @PostMapping(value = "/customer/add")
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.saveCustomerByID(customer);
    }









}
