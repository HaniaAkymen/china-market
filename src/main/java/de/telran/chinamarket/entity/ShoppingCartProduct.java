package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "shopping_cart_product")
@Data
@Entity
public class ShoppingCartProduct {

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


