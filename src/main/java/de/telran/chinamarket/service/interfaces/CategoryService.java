package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Category;

import java.util.List;

/**
 * Service interface for managing categories.
 * Provides methods for retrieving, saving, deleting categories, as well as for retrieving a list of all categories and root categories.
 * Интерфейс сервиса для управления категориями.
 * Предоставляет методы для получения, сохранения, удаления категорий, а также для получения списка всех категорий и корневых категорий.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
public interface CategoryService {
   /**
    * Retrieves a category by its unique identifier.
    * Получает категорию по ее id.
    * @param id the identifier of the category to retrieve
    * @return the category with the specified ID, or null if not found
    */
   Category getByID(Integer id);

   /**
    * Saves a category.
    * Сохраняет категорию.
    * @param category the category to be saved
    */
   void save (Category category);

   /**
    * Retrieves List all root categories.
    * Получает список всех корневых категорий.
    * @return a list of root categories
    */
   List<Category> getAllRootCategories();

   /**
    * Deletes a category by its identifier.
    * Удаляет категорию по ее id.
    * <p>If the category has associated products, deletion will fail with a runtime exception.</p>
    *
    * @param id the identifier of the category to delete
    * @throws RuntimeException if the category is not empty
    */
   void deleteCategory(Integer id);

   /**
    * Retrieves List all categories.
    * Получает список всех категорий.
    * @return a list of all categories
    */
   List<Category> findAll();
}
