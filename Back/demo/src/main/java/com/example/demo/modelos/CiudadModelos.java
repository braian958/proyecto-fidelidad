package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciudades")
public class CiudadModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Ciudad")
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private DepartamentoModelos departamento;

    public void Ciudad() {
    }

    public void Ciudad(Long id, String ciudad, DepartamentoModelos departamento) {
        this.id = id;
        ciudad = ciudad;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        ciudad = ciudad;
    }

    public DepartamentoModelos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoModelos departamento) {
        this.departamento = departamento;
    }

}
