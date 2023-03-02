package com.example.Ejercicio456.controller;

import com.example.Ejercicio456.entities.Laptop;
import com.example.Ejercicio456.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//rest controller nos permite crear los archivos de json y solo controller nos permitira crear archivos html
@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // metodo parra crear los CRUD
    //Buscar todos los libros
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        //recuperar y devolver los libros
        return laptopRepository.findAll();
    }
    //Buscar un libro segun id
    @GetMapping("/api/laptops/{id}")
    //Pathvariable nos va asociar el id de la base de datos con el id del getmapping
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
        // tambien se puede return bookOpt.orElse(null) y sustituye



    }
    //Crear un libro
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders  headers){
        System.out.println(headers.get("User-Agent"));
        //el User-agent es para saber quien nos esta enviando la peticion
        return laptopRepository.save(laptop);
        //guardar el libro recibido por parametros en la base de datos

    }
    //Actualizar un libro
    //borrar un libro

}
