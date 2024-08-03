package com.micro.customerservice.Repositories;

import com.micro.customerservice.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdressRepository extends JpaRepository<Adress,String> {

}
