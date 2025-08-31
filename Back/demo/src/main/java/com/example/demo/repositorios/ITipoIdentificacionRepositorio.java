package com.example.demo.repositorios;

import com.example.demo.modelos.TipoIdentificacionModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoIdentificacionRepositorio extends JpaRepository<TipoIdentificacionModelos,Long> {
}
