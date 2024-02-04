package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.CustomerInfoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerInfoStatus status;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, length = 32, name = "password")
    private String password;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, length = 15, name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private SecurityAccount securityAccount;


    //accuant
    //admin
    //manager












}
