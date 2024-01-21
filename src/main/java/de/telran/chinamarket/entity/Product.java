package de.telran.chinamarket.entity;

import de.telran.chinamarket.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "small_description")
    private String smallDescription;

    @Column(name = "big_description")
    private String bigDescription;

    @Column(name = "small_image_url")
    private String smallImageUrl;

    @Column(name = "big_image_url")
    private String bigImageUrl;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "price")
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "product_category/id")
//    private ProductCategory productCategory;



}
