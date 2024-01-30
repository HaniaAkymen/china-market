package de.telran.chinamarket.controller;

import de.telran.chinamarket.entity.ShopOrder;
import de.telran.chinamarket.service.interfaces.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminShopOrderController {

    private final ShopOrderService shopOrderService;

    @GetMapping(value = "/admin/order/list")
    public List<ShopOrder> getShopOrderList(){
        return shopOrderService.getShopOrderList();
    }



}
