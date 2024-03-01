package de.telran.chinamarket.controller;

import de.telran.chinamarket.dto.PhotoDTO;
import de.telran.chinamarket.service.interfaces.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminPhotoController {

    private final PhotoService photoService;

    @PostMapping(value = "/admin/photo/save")
    @Operation(summary = "Сохранить фото", description = "Сохраняет фото, предоставленную в теле запроса по его Url")
    public void savePhoto(@RequestBody @Valid PhotoDTO photoDTO) {
      photoService.savePhoto(photoDTO.getProductID(), photoDTO.getPhotoUrl());
    }

    @DeleteMapping(value = "/admin/photo/delete/{id}")
    @Operation(summary = "Удалить фото", description = "Удаляет фото по его ID")
    public void deletePhoto(@PathVariable(name = "id") Integer id) {
        photoService.deletePhotoById(id);
    }
}
