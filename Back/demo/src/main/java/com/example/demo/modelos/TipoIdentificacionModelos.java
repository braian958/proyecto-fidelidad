package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoIdentificacion")
public class TipoIdentificacionModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombres")
    private String nombre;

    public void TipoIdentificacion() {
    }

    public void TipoIdentificacion(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
