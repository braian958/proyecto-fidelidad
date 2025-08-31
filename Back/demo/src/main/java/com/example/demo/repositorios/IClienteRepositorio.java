package com.example.demo.repositorios;

import com.example.demo.modelos.ClienteModelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepositorio extends JpaRepository<ClienteModelos,Long> {
}
