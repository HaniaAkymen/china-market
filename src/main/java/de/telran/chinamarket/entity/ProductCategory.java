package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "product_category")
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_category_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany
//    @JoinColumn(name = "product_category/id")
//    private PruductCategory parentCategory;

}
