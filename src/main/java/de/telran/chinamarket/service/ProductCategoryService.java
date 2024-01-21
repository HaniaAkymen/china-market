package de.telran.chinamarket.service;

import de.telran.chinamarket.entity.ProductCategory;


public interface ProductCategoryService {

   ProductCategory getByID(Integer id);

   void save (ProductCategory productCategory);

}
