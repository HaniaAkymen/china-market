package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.CustomerInfoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerInfoStatus status;

//    @Column(name = "name")
//    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(length = 32, name = "password")
    private String password;

    @Column(name = "address")
    private String adress;

    @Column(length = 15, name = "phone")
    private String phone;


    //accuant
    //admin
    //manager












}
