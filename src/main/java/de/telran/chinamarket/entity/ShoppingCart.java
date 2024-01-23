//package de.telran.chinamarket.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Table(name = "shopping_cart")
//@Data
//@Entity
//public class ShoppingCart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "total_count")
//    private Integer totalCount;
//
//    @Column(name = "total_quantity")
//    private Integer totalQuantity;
//
//    @OneToOne
//    @JoinColumn(name = "customer/id")
//    private Customer customer;
//
////    @OneToMany
////    @JoinColumn(name = "product/id")
////    private Product product;
//
//
//}
