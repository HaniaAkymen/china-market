package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Category;

import java.util.List;

/**
 * A service interface for managing categories.
 */
public interface CategoryService {
   /**
    * Retrieves a category by its unique identifier.
    *
    * @param id the identifier of the category to retrieve
    * @return the category with the specified ID, or null if not found
    */
   Category getByID(Integer id);

   /**
    * Saves a category.
    *
    * @param category the category to be saved
    */
   void save (Category category);

   /**
    * Retrieves all root categories.
    *
    * @return a list of root categories
    */
   List<Category> getAllRootCategories();

   /**
    * Deletes a category by its identifier.
    *
    * <p>If the category has associated products, deletion will fail with a runtime exception.</p>
    *
    * @param id the identifier of the category to delete
    * @throws RuntimeException if the category is not empty
    */
   void deleteCategory(Integer id);

   /**
    * Retrieves all categories.
    *
    * @return a list of all categories
    */
   List<Category> findAll();
}
