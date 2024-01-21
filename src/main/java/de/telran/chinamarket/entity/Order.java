package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;



}
