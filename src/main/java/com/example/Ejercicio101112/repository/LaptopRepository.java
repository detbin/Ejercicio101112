package com.example.Ejercicio101112.repository;

import com.example.Ejercicio101112.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JpaRepository nos va a proposionar los metodos CreateRemoveUpdateDelete CRUD
@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
