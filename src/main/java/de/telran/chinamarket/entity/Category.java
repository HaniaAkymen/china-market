package de.telran.chinamarket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "category")
@Entity
@Data
public class Category {

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

    @OneToMany
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id")
    List<Category> subCategorys;
}
