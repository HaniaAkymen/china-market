package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "photo")
@Data
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "product/id")
    private Product product;

}
