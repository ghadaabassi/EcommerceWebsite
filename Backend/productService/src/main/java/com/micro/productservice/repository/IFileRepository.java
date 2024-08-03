package com.micro.productservice.repository;



import com.micro.productservice.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFileRepository extends JpaRepository<File, Integer> {
}