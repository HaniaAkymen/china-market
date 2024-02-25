package de.telran.chinamarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shop_order_product")
@Data
public class ShopOrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JsonIgnore
    private ShopOrder shopOrder;
}
