package com.example.demo.servicios;

import com.example.demo.modelos.PaisModelos;
import com.example.demo.repositorios.IPaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio {

    @Autowired
    private IPaisRepositorio repositorio;

    public boolean guardarRegistro(PaisModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<PaisModelos> obtenerTodos() {
        return repositorio.findAll();
    }

}
