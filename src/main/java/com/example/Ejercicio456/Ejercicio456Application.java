package com.example.Ejercicio456;

import com.example.Ejercicio456.entities.Laptop;
import com.example.Ejercicio456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//estos escaneara todos los beans

public class Ejercicio456Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Ejercicio456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//CRUD
		//crear un libro
		Laptop laptop1 = new Laptop(null, "HP" , "8GB", "Intel5", "1TB", "Windows10",true);
		Laptop laptop2 = new Laptop(null, "TOSHIBA" , "16GB", "Intel7", "3TB", "Windows11",true);
		//almacenar un libro
		System.out.println("Modelos de laptops en la tienda:"+repository.findAll().size());
		repository.save(laptop1);
		repository.save(laptop2);
		//recuperar todos los libros
		System.out.println("Numero de laptops en la base de datos:"+repository.findAll().size());
		// borrar un laptop la L para que lo interprete como L el n'umero 1 y no un integer
		//repository.deleteById(1L);
		System.out.println("Numero de laptops en la base de datos:"+repository.findAll().size());
	}
}
