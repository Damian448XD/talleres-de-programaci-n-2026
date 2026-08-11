package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PuntoReciclaje represents a recycling drop-off point.
 * Demonstrates: Encapsulation (private collections), and Polymorphism use (Residuo ref to ResiduoReciclable).
 */
public class PuntoReciclaje {

    private Long id;
    private String direccion;
    private List<Residuo> residuos;

    public PuntoReciclaje(Long id, String direccion) {
        setId(id);
        setDireccion(direccion);
        this.residuos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) throw new IllegalArgumentException("direccion required");
        this.direccion = direccion.trim();
    }

    // Return unmodifiable view to maintain encapsulation
    public List<Residuo> getResiduos() {
        return Collections.unmodifiableList(residuos);
    }

    // Add residue
    public void recibirResiduo(Residuo residuo) {
        if (residuo == null) throw new IllegalArgumentException("residuo required");
        residuos.add(residuo);
    }

    // Process all residues: demonstrates polymorphism where Residuo reference
    // may refer to ResiduoReciclable and call overridden procesar()
    public List<String> procesarTodos() {
        List<String> resultados = new ArrayList<>();
        for (Residuo r : residuos) {
            resultados.add(r.procesar()); // polymorphic call
        }
        return resultados;
    }

    @Override
    public String toString() {
        return "PuntoReciclaje{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", residuosCount=" + residuos.size() +
                '}';
    }
}
