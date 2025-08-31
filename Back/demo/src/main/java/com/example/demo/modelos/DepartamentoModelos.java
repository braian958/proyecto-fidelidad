package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamentos")
public class DepartamentoModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Departamento")
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private PaisModelos pais;

    public void Departamento() {
    }

    public void Departamento(Long id, String departamento, PaisModelos pais) {
        this.id = id;
        this.departamento = departamento;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public PaisModelos getPais() {
        return pais;
    }

    public void setPais(PaisModelos pais) {
        this.pais = pais;
    }

}
