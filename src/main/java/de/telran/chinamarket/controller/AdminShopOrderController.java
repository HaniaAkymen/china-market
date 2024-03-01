package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.enums.ShopOrderStatus;
import de.telran.chinamarket.service.interfaces.ShopOrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminShopOrderController {

    private final ShopOrderService shopOrderService;

    @GetMapping(value = "/admin/order/list")
    @Operation(summary = "Получить список заказов", description = "Получает список заказов")
    public List<ShopOrder> getShopOrderList(){
        return shopOrderService.getShopOrderList();
    }
    @GetMapping(value = "/admin/order/{id}")
    @Operation(summary = "Получить заказ", description = "Получает заказ по его ID")
    public ShopOrder getShopOrder(@PathVariable (name = "id") Integer id){
        return shopOrderService.getShopOrderById(id);
    }
    @PutMapping(value = "/admin/order/{id}/set_status/{status}")
    @Operation(summary = "Изменить статус заказа", description = "Изменяет статус заказа")
    public void setShopOrderStatus(@PathVariable(name = "status")ShopOrderStatus status, @PathVariable(name = "id") Integer id) {
       shopOrderService.setShopOrderStatus(status, id);
    }
}
