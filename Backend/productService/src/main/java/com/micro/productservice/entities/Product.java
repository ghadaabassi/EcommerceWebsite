package com.micro.productservice.entities;


import com.micro.productservice.enums.Category;
import jakarta.persistence.*;
import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    private File file;

    @Enumerated(EnumType.STRING)
    private Category category;

}
