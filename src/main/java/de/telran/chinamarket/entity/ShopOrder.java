package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.DeliveryType;
import de.telran.chinamarket.enums.PaymentType;
import de.telran.chinamarket.enums.ShopOrderStatus;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ShopOrderStatus status;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopOrder")
    private List<ShopOrderProduct> shopOrderProducts;


}
