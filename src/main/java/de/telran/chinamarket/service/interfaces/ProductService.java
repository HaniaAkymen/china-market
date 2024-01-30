package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Product;


public interface ProductService {

    Product getByID(Integer id);

    void inactiveById(Integer id);

    void save (Product product);


}
