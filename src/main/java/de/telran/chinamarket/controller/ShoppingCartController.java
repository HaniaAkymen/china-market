package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.service.interfaces.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping(value = "/customer/shopping_cart/add_product_to_cart")
    public void addProductToCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        shoppingCartService.addProductToCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());

    }

    @PostMapping(value = "/customer/shopping_cart/delete_product_from_cart" )
    public void deleteProductFromCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        shoppingCartService.deleteProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());

    }

    @PostMapping(value ="/customer/shopping_cart/change_quantity_product_from_cart")
    public void changeQuantityProductFromCart(@RequestBody ShoppingCartProductDTO shoppingCartProductDTO){

        System.out.println("_____________________");
        System.out.println(shoppingCartProductDTO);

        shoppingCartService.changeQuantityProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),shoppingCartProductDTO.getCustomerID());
    }

    @GetMapping(value = "/customer/shopping_cart/get/{customerId}")
    public List<ShoppingCart> getShoppingCart(@PathVariable(name = "customerId") Integer customerId){
        return shoppingCartService.getListShoppingCart(customerId);
    }









}
