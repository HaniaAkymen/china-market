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


    @GetMapping(value = "/admin/customer/get_all")
    public List<Customer> getALLCustomers() {
        return customerService.getAllCustomers();

    }
    @GetMapping(value = "/admin/customer/status/{status}")
    public List<Customer> getCustomersByStatus(@PathVariable(name = "status") String status){

        return customerService.getCustomersByStatus(status);
    }

    @PutMapping(value = "/admin/customer/{id}/set_status/{status}")
    public void setCustomerStatus(@PathVariable(name = "status") CustomerInfoStatus status, @PathVariable(name = "id") Integer id) {

        customerService.setCustomerStatus(status, id);
    }





}





