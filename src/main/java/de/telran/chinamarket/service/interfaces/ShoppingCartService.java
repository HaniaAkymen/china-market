package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.dto.ShoppingCartProductDTO;
import de.telran.chinamarket.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    void addProductToCart (Integer productID, Integer quantity, Integer customerID);

    void deleteProductFromCart(Integer productID, Integer quantity, Integer customerID);

    void changeQuantityProductFromCart(Integer productID, Integer quantity, Integer customerID);

    List<ShoppingCart> getListShoppingCart(Integer customerID);





}
