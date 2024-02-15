package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.service.interfaces.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping(value = "/customer/shopping_cart/add_product_to_cart")
    public void addProductToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ShoppingCartProductDTO shoppingCartProductDTO){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.addProductToCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),customerId);
    }

    @DeleteMapping(value = "/customer/shopping_cart/delete_product_from_cart/{productId}")
    public void deleteProductFromCart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "productId") Integer productId){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.deleteProductFromCart(customerId, productId);
    }

    @PutMapping(value ="/customer/shopping_cart/change_quantity_product_from_cart")
    public void changeQuantityProductFromCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ShoppingCartProductDTO shoppingCartProductDTO){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.changeQuantityProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(), customerId);
    }

    @GetMapping(value = "/customer/shopping_cart/get")
    public List<ShoppingCart> getShoppingCart(@AuthenticationPrincipal UserDetails userDetails) {
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        return shoppingCartService.getListShoppingCart(customerId);
    }









}
