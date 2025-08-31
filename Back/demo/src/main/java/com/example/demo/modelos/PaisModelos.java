package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Paises")
public class PaisModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Pais")
    private String pais;

    @ManyToOne
    @JoinColumn(name = "departamento_id") // columna en la BD
    private DepartamentoModelos departamento;

    public void Pais() {
    }

    public void Pais(Long id, String pais) {
        this.id = id;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
