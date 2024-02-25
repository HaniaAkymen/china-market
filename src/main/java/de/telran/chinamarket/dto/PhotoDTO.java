package de.telran.chinamarket.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO (Data Transfer Object) class representing a photo associated with a product.
 * Used for transferring photo data between client and server.
 * This class holds information about a photo, such as its URL and the ID of the associated product.
 * DTO (Data Transfer Object) класс, представляющий фотографию, связанную с товаром.
 * Используется для передачи данных о фотографии между клиентом и сервером.
 * Этот класс содержит информацию о фотографии, такую как ее URL и идентификатор связанного товара.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
@Data
public class PhotoDTO {
    /**
     * The URL of the photo
     * URL фотографии
     */
    @NotBlank(message = "URL can not be empty")
    private String photoUrl;

    /**
     * The ID of the product associated with the photo.
     * Идентификатор товара, связанного с фотографией.
     */
    private Integer productID;
}
