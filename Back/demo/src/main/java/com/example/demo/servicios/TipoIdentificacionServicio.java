package com.example.demo.servicios;

import com.example.demo.modelos.PaisModelos;
import com.example.demo.modelos.TipoIdentificacionModelos;
import com.example.demo.repositorios.IPaisRepositorio;
import com.example.demo.repositorios.ITipoIdentificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoIdentificacionServicio {

    @Autowired
    private ITipoIdentificacionRepositorio repositorio;

    public boolean guardarRegistro(TipoIdentificacionModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
