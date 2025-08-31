package com.example.demo.servicios;

import com.example.demo.modelos.ClienteModelos;
import com.example.demo.repositorios.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {

    @Autowired
    private IClienteRepositorio repositorio;

    public boolean guardarRegistro(ClienteModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
