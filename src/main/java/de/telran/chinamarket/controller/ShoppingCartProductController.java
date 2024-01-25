package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.ShoppingCartProduct;
import de.telran.chinamarket.service.ShoppingCartProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartProductController {

    private final ShoppingCartProductService shoppingCartProductService;

    @PostMapping(value = "/shopping_cart_product/add_product_to_cart")
    public void addProductToCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        shoppingCartProductService.addProductToCart(shoppingCartProductDTO);

    }


}
