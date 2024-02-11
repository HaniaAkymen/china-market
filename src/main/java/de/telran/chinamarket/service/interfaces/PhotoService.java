package de.telran.chinamarket.service.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * description
 *
 * @author Hanna Akymenko 28.01.2024.
 */
public interface PhotoService {

    void savePhoto(Integer productID, String url);

    void deletePhotoById(Integer id);

    public String urlToBase64(String url) throws IOException;


}
