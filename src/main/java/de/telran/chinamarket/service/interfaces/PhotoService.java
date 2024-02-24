package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Photo;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Interface for managing photos.
 * Интерфнйс сервиса для управлениями фотографиями.
 * @author Hanna Akymenko
 * @version 1.0
 * @since 2024-01-28
 */
public interface PhotoService {

    /**
     * Saves a photo for the given product.
     * Сохраняет фотографию для указанного продукта.
     * @param productID ID of the product
     * @param url URL of the photo
     * @return the saved photo object
     */
    Photo savePhoto(Integer productID, String url);

    /**
     * Deletes a photo by ID.
     * Удаляет фотографию по ID.
     * @param id ID of the photo
     */
    void deletePhotoById(Integer id);
}
