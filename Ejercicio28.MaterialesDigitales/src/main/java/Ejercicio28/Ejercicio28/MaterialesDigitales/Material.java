package Ejercicio28.Ejercicio28.MaterialesDigitales;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Material {
    private String titulo;
    private LocalDate fechaIncorporacion;

    public Material(String titulo, LocalDate fechaIncorporacion) {
        this.titulo = titulo;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int antiguedad() {
        return (int) ChronoUnit.YEARS.between(this.fechaIncorporacion, LocalDate.now());
    }

    public boolean incorporadoAntesDe(int anio) {
        return this.fechaIncorporacion.getYear() < anio;
    }
}