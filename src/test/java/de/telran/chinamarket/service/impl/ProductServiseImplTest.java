package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.enums.ProductStatus;
import de.telran.chinamarket.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
//        assertEquals(toysCat, toysCat1);
        verify(productRepository, times(1)).save(toysCat);

    }

//    @Test
//    public void getProductByCategoryId_ToysCat_success






    }