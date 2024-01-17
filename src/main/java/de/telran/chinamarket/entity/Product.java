package de.telran.chinamarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String smallDescription;

    @Column
    private String bigDescription;

    @Column
    private String smallImageUrl;

    @Column
    private String bigImageUrl;

    @Column
    private Integer categoryId;

    @Column
    private Double price;







}
