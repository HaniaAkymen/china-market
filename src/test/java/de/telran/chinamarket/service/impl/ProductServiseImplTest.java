package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Category;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.enums.ProductStatus;
import de.telran.chinamarket.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiseImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiseImpl productServise;
    @Test
    public void getProductByID_success(){
        //задание начальных значений
        Product whiteUmbrella = new Product();
        whiteUmbrella.setId(2);
        whiteUmbrella.setName("WhiteUmbrella");

        when(productRepository.findById(2)).thenReturn(Optional.of(whiteUmbrella));

        //запустить сам метод
        Product pinkUmbrella = productServise.getByID(2);

        //проверка результата
        assertEquals(whiteUmbrella, pinkUmbrella);
        verify(productRepository, times(1)).findById(2);
    }

    @Test
    public void saveProduct_ToysCat_success(){
        //задание начальных значений
        Product toysCat = new Product();
        toysCat.setName("Cat_toys");
        toysCat.setId(1);

        //запустить сам метод
       productServise.save(toysCat);

       //проверка результата
        verify(productRepository,times(1)).save(toysCat);
    }
    @Test
    public void inactiveProduct_ToysCat_success(){
        //задание начальных значений
        Product toysCat = new Product();
        toysCat.setName("Cat_toys");
        Integer toysCatId = 1;
        toysCat.setId(toysCatId);
        toysCat.setStatus(ProductStatus.INACTIVE);

        when(productRepository.findById(1)).thenReturn(Optional.of(toysCat));

        //запустить сам метод
        productServise.inactiveById(toysCatId);

        //проверка результата
        verify(productRepository, times(1)).save(toysCat);
    }
    @Test
    public void activeProduct_ToysCat_success() {
        //задание начальных значений
        Product toysCat = new Product();
        toysCat.setName("Cat_toys");
        Integer toysCatId = 6;
        toysCat.setId(toysCatId);
        toysCat.setStatus(ProductStatus.ACTIVE);

        when(productRepository.findById(6)).thenReturn(Optional.of(toysCat));

        //запустить сам метод
        productServise.activeById(toysCatId);

        //проверка результата
        verify(productRepository, times(1)).save(toysCat);
    }

    @Test
    public void getProductsByCategoryId_success(){

        List<Product> categoryProduct = new ArrayList<>();

        Product toysCat = new Product();
        toysCat.setId(6);
        toysCat.setName("Cat_toys");

        Product toysDog = new Product();
        toysDog.setId(2);
        toysDog.setName("WhiteUmbrella");

        Product toysFish = new Product();
        toysFish.setId(2);
        toysFish.setName("WhiteUmbrella");

        Category categoryToys = new Category();
        categoryToys.setId(1L);
        categoryProduct.add(toysCat);
        categoryProduct.add(toysDog);
        categoryProduct.add(toysFish);

        when(productRepository.getProductsByCategoryId(1)).thenReturn(categoryProduct);

        List<Product> categoryProduct1 = productServise.getProductsByCategoryId(1);

        assertEquals(categoryProduct, categoryProduct1);

        verify(productRepository, times(1)).getProductsByCategoryId(1);
        }

        @Test
        public void getAllProduct_success () {

            List<Product> allProducts = new ArrayList<>();

            Product toysCat = new Product();
            toysCat.setId(6);
            toysCat.setName("Cat_toys");

            Product toysDog = new Product();
            toysDog.setId(2);
            toysDog.setName("WhiteUmbrella");

            Product toysFish = new Product();
            toysFish.setId(2);
            toysFish.setName("WhiteUmbrella");

            allProducts.add(toysCat);
            allProducts.add(toysDog);
            allProducts.add(toysFish);

            when(productRepository.findAll()).thenReturn(allProducts);

            List<Product> allProducts2 = productServise.getAllProducts();

            assertEquals(allProducts, allProducts2);

            verify(productRepository, times(1)).findAll();

        }




    }