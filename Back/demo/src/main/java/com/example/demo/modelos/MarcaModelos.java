package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Marcas")
public class MarcaModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Marca")
    private String marca;

    public void Marca() {
    }

    public void Marca(Long id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
