package Ejercicio28.Ejercicio28.MaterialesDigitales;

import java.time.LocalDate;

public class LibroDigital extends Material implements Descargable {
    private static final String CARPETA = "libros/";

    private String autor;
    private String nombreArchivo;
    private double pesoArchivoMB;

    public LibroDigital(String titulo, LocalDate fechaIncorporacion,
                        String autor, String nombreArchivo, double pesoArchivoMB) {
        super(titulo, fechaIncorporacion);
        this.autor = autor;
        this.nombreArchivo = nombreArchivo;
        this.pesoArchivoMB = pesoArchivoMB;
    }

    public String getAutor() {
        return this.autor;
    }

    @Override
    public String enlaceDeDescarga() {
        return "https://biblioteca.example.org/descargas/" + CARPETA + this.nombreArchivo;
    }

    @Override
    public double tamanioEnMB() {
        return this.pesoArchivoMB;
    }
}