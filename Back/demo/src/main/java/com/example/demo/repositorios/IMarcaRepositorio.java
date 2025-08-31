package com.example.demo.repositorios;

import com.example.demo.modelos.MarcaModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepositorio extends JpaRepository<MarcaModelos,Long> {
}
