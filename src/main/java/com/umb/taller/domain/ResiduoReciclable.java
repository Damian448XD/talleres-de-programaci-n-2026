package com.umb.taller.domain;

import java.time.LocalDateTime;

/**
 * ResiduoReciclable extends Residuo.
 * Demonstrates: Inheritance (extends Residuo), Polymorphism (overrides procesar()).
 */
public class ResiduoReciclable extends Residuo {

    // Encapsulation: private attributes specific to recyclable waste
    private String tipoMaterial; // e.g., 'Plastico', 'Vidrio', 'Papel'
    private boolean limpio;

    public ResiduoReciclable(Long id, String nombre, double pesoKg, LocalDateTime fechaGeneracion,
                             String tipoMaterial, boolean limpio) {
        super(id, nombre, pesoKg, fechaGeneracion);
        setTipoMaterial(tipoMaterial);
        setLimpio(limpio);
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        if (tipoMaterial == null || tipoMaterial.isBlank()) throw new IllegalArgumentException("tipoMaterial required");
        this.tipoMaterial = tipoMaterial.trim();
    }

    public boolean isLimpio() {
        return limpio;
    }

    public void setLimpio(boolean limpio) {
        this.limpio = limpio;
    }

    // Polymorphism: override procesar() with behavior specific to recyclable waste
    @Override
    public String procesar() {
        // If clean, easier to recycle; otherwise requires lavado step
        if (isLimpio()) {
            return String.format("Reciclado: %s (material=%s, peso=%.2fkg)", getNombre(), tipoMaterial, getPesoKg());
        } else {
            return String.format("No se puede reciclar directamente: %s - requiere limpieza (material=%s)", getNombre(), tipoMaterial);
        }
    }

    @Override
    public String toString() {
        return "ResiduoReciclable{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", pesoKg=" + getPesoKg() +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                ", limpio=" + limpio +
                '}';
    }
}
