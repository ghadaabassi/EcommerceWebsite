package com.micro.productservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    @Lob
    @Column(length = 1000000000)
    private byte[] data;



    @Override
    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", data length=" + (data != null ? data.length : 0) +
                '}';
    }
}