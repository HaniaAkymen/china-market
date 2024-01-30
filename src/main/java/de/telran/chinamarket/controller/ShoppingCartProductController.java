package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.service.interfaces.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartProductController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping(value = "/shopping_cart/add_product_to_cart")
    public void addProductToCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        shoppingCartService.addProductToCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());

    }

    @PostMapping(value = "/shopping_cart/delete_product_from_cart" )
    public void deleteProductFromCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        shoppingCartService.deleteProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());

    }

    @PostMapping(value ="/shopping_cart/change_quantity_product_from_cart")
    public void changeQuantityProductFromCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        System.out.println("_____________________");
        System.out.println(shoppingCartProductDTO);

        shoppingCartService.changeQuantityProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());
    }







}
