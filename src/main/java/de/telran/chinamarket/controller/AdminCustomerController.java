package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.Customer;
import de.telran.chinamarket.enums.CustomerInfoStatus;
import de.telran.chinamarket.service.interfaces.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminCustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/admin/customer/{id}")
    @Operation(summary = "Получить клиента", description = "Получает информацию о клиенте")
    public Customer getCustomer(@PathVariable(value = "id") Integer id, HttpServletRequest request) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }
    @GetMapping(value = "/admin/customer/get_all")
    @Operation(summary = "Получить список клиентов", description = "Получает список всех клиентов")
    public List<Customer> getALLCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping(value = "/admin/customer/status/{status}")
    @Operation(summary = "Получить список клиентов по статусу", description = "Получает список клиентов по определенному статусу")
    public List<Customer> getCustomersByStatus(@PathVariable(name = "status") String status){
        return customerService.getCustomersByStatus(status);
    }
    @PutMapping(value = "/admin/customer/{id}/set_status/{status}")
    @Operation(summary = "Изменить статус клиена", description = "Изменяет статус клиента по его ID")
    public void setCustomerStatus(@PathVariable(name = "status") CustomerInfoStatus status, @PathVariable(name = "id") Integer id) {
        customerService.setCustomerStatus(status, id);
    }
}
