package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_type")
    private Long paymentType;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;



}
