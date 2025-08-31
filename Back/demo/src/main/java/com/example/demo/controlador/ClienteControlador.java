package com.example.demo.controlador;

import com.example.demo.modelos.CiudadModelos;
import com.example.demo.modelos.ClienteModelos;
import com.example.demo.servicios.CiudadServicio;
import com.example.demo.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteControlador {

    @Autowired
    ClienteServicio servicio;

    //metodo para responder al front
    @PostMapping("cliente")
    public ResponseEntity<?> responderAlGuardar(@RequestBody ClienteModelos datosDelFront){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.guardarRegistro(datosDelFront));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
