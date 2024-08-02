package com.micro.productservice.entities;


import com.micro.productservice.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double qt;

    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    private File file;

    @Enumerated(EnumType.STRING)
    private Category category;

}
