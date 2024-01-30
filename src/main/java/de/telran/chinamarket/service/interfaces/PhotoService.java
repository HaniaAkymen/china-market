package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Photo;

/**
 * description
 *
 * @author Hanna Akymenko 28.01.2024.
 */
public interface PhotoService {

    void savePhoto(Integer productID, String url);

    void deletePhotoById(Integer id);


}
