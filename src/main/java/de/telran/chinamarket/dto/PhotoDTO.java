package de.telran.chinamarket.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data

public class PhotoDTO {

    @NotBlank(message = "URL can not be empty")
    private String photoUrl;

    private Integer productID;

}
