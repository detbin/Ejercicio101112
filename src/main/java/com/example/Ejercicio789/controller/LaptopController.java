package com.example.Ejercicio456.controller;

import com.example.Ejercicio456.entities.Laptop;
import com.example.Ejercicio456.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//rest controller nos permite crear los archivos de json y solo controller nos permitira crear archivos html
@RestController
public class LaptopController {
    //variable para lanzar el mensaje de warning en caso de querer crear un libro por id
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // metodo parra crear los CRUD
    //Buscar todos los laptops
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
    //Crear un laptop
    @PostMapping("/api/laptops")
    public ResponseEntity<Object> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders  headers){
        System.out.println(headers.get("User-Agent"));
        //el User-agent es para saber quien nos esta enviando la peticion
        //hacemos un if para mandar un mensaje de error en caso de querer crear un laptop con un id que ya existe
        if(laptop.getId() != null){
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result= laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
        //guardar el laptop recibido por parametros en la base de datos
    }

    //Actualizar un laptop
    @PutMapping("/api/laptops")
    public ResponseEntity<Object> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("trying to update a laptop without id");
            return ResponseEntity.badRequest().build();
        }
        //verificamos que existe el laptop
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to Update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result= laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    //borrar un laptop
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying to Delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteall(){

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
