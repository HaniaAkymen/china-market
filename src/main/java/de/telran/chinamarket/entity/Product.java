package de.telran.chinamarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.chinamarket.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "small_description")
    private String smallDescription;

    @Column(name = "big_description")
    private String bigDescription;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "product")
    private List<Photo> photos;

    @ManyToOne
    @JsonIgnore
    private Category category;
}
