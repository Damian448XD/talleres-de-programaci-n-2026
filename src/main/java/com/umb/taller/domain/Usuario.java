package com.umb.taller.domain;

/**
 * Usuario domain class.
 * Demonstrates: Encapsulation (private fields, getters/setters, validation).
 */
public class Usuario {

    // Encapsulation: private attributes
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private int puntos;

    // Constructor with basic validation
    public Usuario(Long id, String nombre, String email, String telefono) {
        setId(id);
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
        this.puntos = 0;
    }

    // Encapsulation: getters and setters with validation
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id must be positive and non-null");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre cannot be empty");
        }
        this.nombre = nombre.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email must contain '@'");
        }
        this.email = email.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono == null ? "" : telefono.trim();
    }

    public int getPuntos() {
        return puntos;
    }

    private void setPuntos(int puntos) {
        this.puntos = Math.max(0, puntos);
    }

    // Business methods
    public void agregarPuntos(int cantidad) {
        if (cantidad <= 0) return;
        setPuntos(this.puntos + cantidad);
    }

    public boolean canjearPuntos(int cantidad) {
        if (cantidad <= 0) return false;
        if (this.puntos >= cantidad) {
            setPuntos(this.puntos - cantidad);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
