package com.example.demo.repositorios;

import com.example.demo.modelos.CiudadModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadRepositorio extends JpaRepository<CiudadModelos , Long> {
    List<CiudadModelos> findByDepartamentoId(Long departamentoId);
}
