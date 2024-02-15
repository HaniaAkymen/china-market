package de.telran.chinamarket.service.interfaces;

import de.telran.chinamarket.entity.Photo;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * description
 *
 * @author Hanna Akymenko 28.01.2024.
 */
public interface PhotoService {

    Photo savePhoto(Integer productID, String url);

    void deletePhotoById(Integer id);



}
