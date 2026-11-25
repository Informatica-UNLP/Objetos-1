package Ejercicio28.Ejercicio28.MaterialesDigitales;

import java.time.LocalDate;

public class LibroImpreso extends Material {
    private String autor;
    private String ubicacion;

    public LibroImpreso(String titulo, LocalDate fechaIncorporacion,
                        String autor, String ubicacion) {
        super(titulo, fechaIncorporacion);
        this.autor = autor;
        this.ubicacion = ubicacion;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }
}
