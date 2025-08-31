package com.example.demo.servicios;

import com.example.demo.modelos.CiudadModelos;
import com.example.demo.repositorios.ICiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CiudadServicio {
    @Autowired
    private ICiudadRepositorio repositorio;

    public boolean guardarRegistro(CiudadModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<CiudadModelos> obtenerPorDepartamento(Long departamentoId) throws Exception {
        try {
            return repositorio.findByDepartamentoId(departamentoId);
        } catch (Exception error) {
            throw new Exception("Error al obtener ciudades por departamento: " + error.getMessage());
        }
    }


}
