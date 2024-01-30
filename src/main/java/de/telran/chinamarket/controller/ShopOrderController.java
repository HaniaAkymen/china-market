package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShopOrderDTO;
import de.telran.chinamarket.service.interfaces.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopOrderController {

    private final ShopOrderService shopOrderService;

    @PostMapping(value = "/shop_order/save_order")
    public void addOrder(@RequestBody ShopOrderDTO shopOrderDTO){

        shopOrderService.saveOrder(shopOrderDTO.getPaymentType(),shopOrderDTO.getDeliveryType(), shopOrderDTO.getCustomerID());
    }

}
