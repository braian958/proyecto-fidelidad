package com.example.demo.controlador;

import com.example.demo.modelos.CiudadModelos;
import com.example.demo.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CiudadControlador {

    @Autowired
    CiudadServicio servicio;

    //metodo para responder al front
    @PostMapping("ciudad")
    public ResponseEntity<?> responderAlGuardar(@RequestBody CiudadModelos datosDelFront){
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

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<?> obtenerCiudadesPorDepartamento(@PathVariable String departamentoId) throws Exception {
        return ResponseEntity.ok(servicio.obtenerPorDepartamento(Long.valueOf(departamentoId)));
    }

}
