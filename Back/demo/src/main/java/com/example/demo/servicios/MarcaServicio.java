package com.example.demo.servicios;

import com.example.demo.modelos.DepartamentoModelos;
import com.example.demo.modelos.MarcaModelos;
import com.example.demo.repositorios.IDepartamentoRepositorio;
import com.example.demo.repositorios.IMarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServicio {

    @Autowired
    private IMarcaRepositorio repositorio;

    public boolean guardarRegistro(MarcaModelos datosUsuario) throws Exception {
        try {
            repositorio.save(datosUsuario);
            return true;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }



}
