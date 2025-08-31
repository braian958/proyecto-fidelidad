package com.example.demo.repositorios;

import com.example.demo.modelos.DepartamentoModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentoRepositorio extends JpaRepository<DepartamentoModelos , Long> {

    List<DepartamentoModelos> findByPaisId(Long paisId);
}
