package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.SecurityAccount;
import de.telran.chinamarket.entity.ShoppingCart;
import de.telran.chinamarket.service.interfaces.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Добавить продукт в корзину", description = "Добавляет продукт в корзину согасно ID клиента, ID заказа и количеству товара")
    public void addProductToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ShoppingCartProductDTO shoppingCartProductDTO){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.addProductToCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(),customerId);
    }

    @DeleteMapping(value = "/customer/shopping_cart/delete_product_from_cart/{productId}")
    @Operation(summary = "Удалить продукт из корзины", description = "Удаляет продукт из корзины по ID клиента и ID продукта")
    public void deleteProductFromCart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "productId") Integer productId){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.deleteProductFromCart(customerId, productId);
    }

    @PutMapping(value ="/customer/shopping_cart/change_quantity_product_from_cart")
    @Operation(summary = "Изменить количество продукта в корзине", description = "Изменяет количество товара в корзине по ID продукта и ID клиента")
    public void changeQuantityProductFromCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ShoppingCartProductDTO shoppingCartProductDTO){
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        shoppingCartService.changeQuantityProductFromCart(shoppingCartProductDTO.getProductID(),shoppingCartProductDTO.getQuantity(), customerId);
    }

    @GetMapping(value = "/customer/shopping_cart/get")
    @Operation(summary = "Получить список товаров в корзине", description = "Получает список товаров в корзине авторизованного клиента")
    public List<ShoppingCart> getShoppingCart(@AuthenticationPrincipal UserDetails userDetails) {
        Integer customerId = ((SecurityAccount) userDetails).getCustomerId();
        return shoppingCartService.getListShoppingCart(customerId);
    }
}
