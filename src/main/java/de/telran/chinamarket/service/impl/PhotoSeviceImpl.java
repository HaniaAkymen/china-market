package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Photo;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.repository.PhotoRepository;
import de.telran.chinamarket.service.interfaces.PhotoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

/**
 * Implementation of the PhotoService interface.
 * Реализация интерфейса PhotoService.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
@Service
@RequiredArgsConstructor
public class PhotoSeviceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final ProductRepository productRepository;

    @SneakyThrows
    @Transactional
    @Override
    public Photo savePhoto(Integer productID, String url) {

        Photo photo = new Photo();
        String base64Image = urlToBase64(url);
        photo.setUrl(url);
        photo.setBase64Image(base64Image);

       Optional<Product> productOptional = productRepository.findById(productID);
       if (!productOptional.isPresent()){
           throw new EntityNotFoundException("product not found");
       }
       photo.setProduct(productOptional.get());
       photoRepository.save(photo);

       return photo;
    }

    /**
     * Converts an image from the given URL to Base64 format.
     * Преобразует изображение с указанного URL в формат Base64.
     * @param imageURL imageURL URL of the image
     * @return Base64 representation of the image
     * @throws IOException if an I/O error occurs
     */
    private String urlToBase64(String imageURL) throws IOException {

        java.net.URL url = new java.net.URL(imageURL);
        byte[] imegeData = url.openStream().readAllBytes(); //качает файл

        String base64Image = Base64.getEncoder().encodeToString(imegeData); //кодирует данные изображения в Base64
        return base64Image;
    }
    @Transactional
    @Override
    public void deletePhotoById(Integer id) {
        Optional<Photo> photoOptional = photoRepository.findById(id);
        if (!photoOptional.isPresent()) {
            return;
        }
        photoRepository.delete(photoOptional.get());
    }
}
