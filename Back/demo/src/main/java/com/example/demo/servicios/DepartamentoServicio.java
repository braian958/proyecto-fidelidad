package com.example.demo.servicios;

import com.example.demo.modelos.CiudadModelos;
import com.example.demo.modelos.DepartamentoModelos;
import com.example.demo.repositorios.IDepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServicio {

    @Autowired
    private IDepartamentoRepositorio repositorio;

    public boolean guardarRegistro(DepartamentoModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<DepartamentoModelos> obtenerPorPais(Long paisId) throws Exception {
        try {
            return repositorio.findByPaisId(paisId);
        } catch (Exception error) {
            throw new Exception("Error al obtener departamentos por país: " + error.getMessage());
        }
    }


}
