package de.telran.chinamarket.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    @Size(min = 3)
    private String email;

    @NotBlank(message = "The field must not be blank")
    private String password;

    @NotBlank(message = "The field must not be blank")
    private String address;

    @NotBlank(message = "The field must not be blank")
    @Digits(integer = 11, fraction = 0)
    private String phone;

}
