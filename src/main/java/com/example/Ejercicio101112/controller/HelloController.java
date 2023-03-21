package com.example.Ejercicio101112.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//para hacer pruebas

@RestController
public class HelloController {
   @Value("${app.message}")
   String message;
    @GetMapping("/hola")
    //get mapping nos abrira en el puerto correspondiente aqui el 3000 la url /hola

    public String holamundo(){
        return "Hola mundo es David y estoy muy entusiasmado con spring";
    }
    @GetMapping("/bootstrap")
    public String bootsrap(){
        //con """ podemos poner lo que queramos adentro sin concatenar con +
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                  </head>
                  <body>
                    <h1>Hola mundo desde sprin boot</h1>
                  </body>
                </html>
                """;
    }
}
