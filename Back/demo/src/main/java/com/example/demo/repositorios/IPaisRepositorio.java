package com.example.demo.repositorios;

import com.example.demo.modelos.CiudadModelos;
import com.example.demo.modelos.PaisModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaisRepositorio extends JpaRepository<PaisModelos,Long> {
    List<CiudadModelos> findByDepartamentoId(Long departamentoId);
}
