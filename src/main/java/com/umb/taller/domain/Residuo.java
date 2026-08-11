package com.umb.taller.domain;

import java.time.LocalDateTime;

/**
 * Abstract Residuo class.
 * Demonstrates: Abstraction (abstract class + common behavior), Encapsulation.
 */
public abstract class Residuo {

    // Encapsulation: private attributes
    private Long id;
    private String nombre;
    private double pesoKg;
    private LocalDateTime fechaGeneracion;

    // Constructor
    public Residuo(Long id, String nombre, double pesoKg, LocalDateTime fechaGeneracion) {
        setId(id);
        setNombre(nombre);
        setPesoKg(pesoKg);
        setFechaGeneracion(fechaGeneracion == null ? LocalDateTime.now() : fechaGeneracion);
    }

    // Getters and setters with validation
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre required");
        this.nombre = nombre.trim();
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) throw new IllegalArgumentException("peso must be > 0");
        this.pesoKg = pesoKg;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion == null ? LocalDateTime.now() : fechaGeneracion;
    }

    // Abstraction: common behavior
    public String descripcion() {
        return String.format("Residuo[id=%d, nombre=%s, peso=%.2fkg]", id, nombre, pesoKg);
    }

    // Abstraction: abstract method that subclasses must implement
    public abstract String procesar();
}
