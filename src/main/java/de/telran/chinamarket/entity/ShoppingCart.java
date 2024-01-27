package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "shopping_cart")
@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;


}


