package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

//    @BeforeEach
//    void setUp() {
//    Category tools = new Category();
//        tools.setId(3L);
//        tools.setName("Tools");
//        tools.setDescription("Good Tools");
//    }

    @Test
    public void getById_Category_Umbrellas_success(){
        Category umbrellas = new Category();
        umbrellas.setId(3L);
        umbrellas.setName("Umbrellas");

        when(categoryRepository.findById(3)).thenReturn(Optional.of(umbrellas));

        Category category = categoryService.getByID(3);

        assertEquals(umbrellas, category);
        verify(categoryRepository, times(1)).findById(3);
    }
    @Test
    public void save_Category_tools_success(){
        //задание начальных значений
        Category tools = new Category();
        tools.setName("Tools");
        tools.setId(5L);
        tools.setDescription("Good Tools");

        categoryService.save(tools);

        verify(categoryRepository, times(1)).save(tools);
    }
    @Test
    public void getAllRootCategorys_success(){
        //задание начальных значений
        List<Category> RootCategoryList = new ArrayList<>();
        Category first = new Category();
        Category second = new Category();
        Category third= new Category();

        RootCategoryList.add(first);
        RootCategoryList.add(second);
        RootCategoryList.add(third);

        when(categoryRepository.getAllRootCategorys()). thenReturn(RootCategoryList);

        List<Category> categoryList1 = categoryService.getAllRootCategories();

        assertEquals(RootCategoryList, categoryList1);
        verify(categoryRepository, times(1)).getAllRootCategorys();
    }

    @Test//проверить
    public void deleteCategory_Tools_success(){

        Category tools = new Category();
        tools.setName("Tools");
        tools.setId(3L);
        tools.setDescription("Good Tools");

        Optional<Category> optionalCategory= Optional.of(tools);

        when(categoryRepository.findById(3)).thenReturn(optionalCategory);

        //запустить сам метод
        categoryService.deleteCategory(3);

        //проверка результата
        verify(categoryRepository, times(1)).delete(tools);
    }
}