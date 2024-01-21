package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_product")
@Data
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

//    @OneToMany
//    @JoinColumn(name = "product/id")
//    private Product product;

//    @OneToMany
//    @JoinColumn(name = "order/id")
//    private Order order;


}
