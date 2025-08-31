package com.example.demo.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Clientes")
public class ClienteModelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_identificacion_id", nullable = false)
    private TipoIdentificacionModelos tipoIdentificacion;

    @Column(length = 50, nullable = false)
    private String numeroIdentificacion;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private java.time.LocalDate fechaNacimiento;

    @Column(length = 150, nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private CiudadModelos ciudad;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private PaisModelos pais;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private DepartamentoModelos departamento;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private MarcaModelos marca;

    public void Cliente() {
    }

    public void Cliente(Long id, TipoIdentificacionModelos tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, CiudadModelos ciudad, MarcaModelos marca) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoIdentificacionModelos getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionModelos tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CiudadModelos getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModelos ciudad) {
        this.ciudad = ciudad;
    }

    public MarcaModelos getMarca() {
        return marca;
    }

    public void setMarca(MarcaModelos marca) {
        this.marca = marca;
    }

}
