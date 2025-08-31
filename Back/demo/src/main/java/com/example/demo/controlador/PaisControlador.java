package com.example.demo.controlador;

import com.example.demo.modelos.PaisModelos;
import com.example.demo.servicios.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaisControlador {
    @Autowired
    PaisServicio servicio;

    //metodo para responder al front
    @PostMapping("pais")
    public ResponseEntity<?> responderAlGuardar(@RequestBody PaisModelos datosDelFront){
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

    @GetMapping("pais")
    public ResponseEntity<?> obtenerPaises(PaisModelos datosFront) throws Exception {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

}
