package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Product;

import java.util.List;


public interface ProductService {

    Product getByID(Integer id);

    void inactiveById(Integer id);

    void activeById(Integer id);

    void save (Product product);

    List<Product> getProductsByCategoryId(Integer categoryId);

    List<Product> getAllProducts();



}
