package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Category;

import java.util.List;


public interface CategoryService {

   Category getByID(Integer id);

   void save (Category category);

   List<Category> getAllRootCategorys();






}
