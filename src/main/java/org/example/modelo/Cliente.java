package org.example.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private Long totalVentas = 0L;

    private String estado = "activo";

    public Cliente() {
    }

    public Cliente(String nombre, Long totalVentas, String estado) {
        this.nombre = nombre;
        this.totalVentas = totalVentas;
        this.estado = estado;
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

    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", totalVentas=" + totalVentas +
                ", estado='" + estado + '\'' +
                '}';
    }



}
