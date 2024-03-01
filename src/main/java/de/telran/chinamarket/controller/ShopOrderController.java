package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShopOrderDTO;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.service.interfaces.ShopOrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopOrderController {

    private final ShopOrderService shopOrderService;

    @PostMapping(value = "/customer/shop_order/save_order")
    @Operation(summary = "Создать заказ", description = "Создает заказ для авторизованного клиента на основе его списка товаров в корзине")
    public void addOrder(@RequestBody ShopOrderDTO shopOrderDTO, @AuthenticationPrincipal UserDetails userDetails){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shopOrderService.saveOrder(shopOrderDTO.getPaymentType(),shopOrderDTO.getDeliveryType(),customerId);
    }
}
