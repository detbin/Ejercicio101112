package com.example.Ejercicio101112.entities;

import jakarta.persistence.*;


@Entity
//para que los atributos sean las columnas de la base de datos
@Table(name="laptop")
//para ponerle nombre a la base de datos

public class Laptop {
    //atributos
    @Id
    //para que le coloque un id a cada fila de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //para que maneje los id y no tengamos que estar pendientes de el manejo de los id
    private Long id;
    private String model;
    private String memory;
    private String processor;
    private String hd;
    private String system;
    private boolean available;
    //constructores

    public Laptop() {
    }

    public Laptop(Long id, String model, String memory, String processor, String hd, String system, boolean available) {
        this.id = id;
        this.model = model;
        this.memory = memory;
        this.processor = processor;
        this.hd = hd;
        this.system = system;
        this.available = available;
    }
//metodos

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMemory() {
        return memory;
    }

    public String getProcessor() {
        return processor;
    }

    public String getHd() {
        return hd;
    }

    public String getSystem() {
        return system;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}