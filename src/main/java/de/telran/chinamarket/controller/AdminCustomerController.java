package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminCustomerController {

    private final CustomerService customerService;

    @PutMapping(value = "customer/{id}")
    public void updateCustomerBy(@PathVariable(value = "id") Integer id) {
        customerService.updateCustomerById(id);
    }

    @GetMapping(value = "/customer/get_all")
    public List<Customer> getALLCustomers() {
        return customerService.getAllCustomers();

    }

    @GetMapping(value = "/customer/status")
    public List<Customer> getCustomersByStatus(@RequestParam(name = "status") CustomerInfoStatus status){
        return customerService.getCustomersByStatus(status);

    }



}





