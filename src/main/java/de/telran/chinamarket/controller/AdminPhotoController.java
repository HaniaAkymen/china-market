package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.PhotoDTO;
import de.telran.chinamarket.service.interfaces.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminPhotoController {

    private final PhotoService photoService;

    @PostMapping(value = "/admin/photo/save")
    public void savePhoto(@RequestBody PhotoDTO photoDTO) {
        System.out.println("*************");
        System.out.println(photoDTO);

        photoService.savePhoto(photoDTO.getProductID(), photoDTO.getPhotoUrl());
    }

    @DeleteMapping(value = "/admin/photo/delete/{id}")
    public void deletePhoto(@PathVariable Integer id) {

        photoService.deletePhotoById(id);
    }


}
