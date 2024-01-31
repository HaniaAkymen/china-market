package de.telran.chinamarket.service.impl;

import de.telran.chinamarket.entity.Photo;
import de.telran.chinamarket.entity.Product;
import de.telran.chinamarket.repository.ProductRepository;
import de.telran.chinamarket.repository.CustomerRepository;
import de.telran.chinamarket.repository.PhotoRepository;
import de.telran.chinamarket.service.interfaces.PhotoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * description
 *
 * @author Hanna Akymenko 28.01.2024.
 */
@Service
@RequiredArgsConstructor
public class PhotoSeviceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void savePhoto(Integer productID, String url) {

        System.out.println("__________________________");
        System.out.println(productID);
        System.out.println(url);

        Photo photo = new Photo();
        photo.setUrl(url);

       Optional<Product> productOptional = productRepository.findById(productID);
       if (!productOptional.isPresent()){
           throw new EntityNotFoundException("product not found");
       }
       photo.setProduct(productOptional.get());
       photoRepository.save(photo);


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
