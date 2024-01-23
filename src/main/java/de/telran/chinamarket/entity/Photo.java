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


    //https://ae01.alicdn.com/kf/S3541d8fb85b141a491089e1464cbcbd1w/50-70cm-Cute-Soft-Long-Cat-Plush-Toys-Stuffed-Pause-Office-Nap-Pillow-Bed-Sleep-Home.jpg_80x80.jpg_.webp

    //https://ae01.alicdn.com/kf/S2e4c2febf873492b9fed51af83ea6326E/50-70cm-Cute-Soft-Long-Cat-Plush-Toys-Stuffed-Pause-Office-Nap-Pillow-Bed-Sleep-Home.jpg_640x640.jpg_.webp

}
