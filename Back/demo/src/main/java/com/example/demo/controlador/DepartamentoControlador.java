package com.example.demo.controlador;

import com.example.demo.modelos.DepartamentoModelos;
import com.example.demo.servicios.ClienteServicio;
import com.example.demo.servicios.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartamentoControlador {

    @Autowired
    DepartamentoServicio servicio;

    //metodo para responder al front
    @PostMapping("departamento")
    public ResponseEntity<?> responderAlGuardar(@RequestBody DepartamentoModelos datosDelFront){
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

    @GetMapping("/pais/{paisId}")
    public ResponseEntity<?> obtenerDepartamentosPorPais( @PathVariable Long paisId) throws Exception {
        return ResponseEntity.ok(servicio.obtenerPorPais(paisId));
    }



}
