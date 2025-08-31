package com.example.demo.controlador;

import com.example.demo.modelos.PaisModelos;
import com.example.demo.modelos.TipoIdentificacionModelos;
import com.example.demo.servicios.PaisServicio;
import com.example.demo.servicios.TipoIdentificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoIdentificacionControlador {

    @Autowired
    TipoIdentificacionServicio servicio;

    //metodo para responder al front
    @PostMapping("tipoIdentificacion")
    public ResponseEntity<?> responderAlGuardar(@RequestBody TipoIdentificacionModelos datosDelFront){
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
