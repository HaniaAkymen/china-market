package de.telran.chinamarket.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO (Data Transfer Object) class representing customer data.
 * Used for transferring data between customer and server.
 * This class holds information about a customer, such as first name, last name, email,
 * password, address, and phone number
 * DTO (Data Transfer Object) класс, представляющий данные о клиенте.
 * Используется для передачи данных между клиентом и сервером.
 * Этот класс содержит информацию о клиенте, такую как имя, фамилия, электронная почта,
 * пароль, адрес и номер телефона.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-01-28
 */
@Data
public class CustomerDTO {

    /**
     * Customer's first name
     * Имя клиента
     */
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    /**
     * Customer's last name
     * Фамилия клиента
     */
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    /**
     * Customer's email
     * Электронная почта клиента
     */
    @Email(message = "Please provide a valid email address")
    @Size(min = 3)
    private String email;

    /**
     * Customer's password
     * Пароль клиента
     */
    @NotBlank(message = "The field must not be blank")
    private String password;

    /**
     * Customer's address
     * Адрес клиента
     */
    @NotBlank(message = "The field must not be blank")
    private String address;

    /**
     * Customer's phone number
     * Номер телефона клиента
     */
    @NotBlank(message = "The field must not be blank")
    @Digits(integer = 11, fraction = 0)
    private String phone;
}
