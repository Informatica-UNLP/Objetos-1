package Ejercicio28.Ejercicio28.MaterialesDigitales;

import java.time.LocalDate;

public class RevistaDigital extends Material implements Descargable {
    private static final String CARPETA = "revistas/";

    private int numero;
    private String nombreArchivo;
    private double pesoArchivoMB;

    public RevistaDigital(String titulo, LocalDate fechaIncorporacion,
                          int numero, String nombreArchivo, double pesoArchivoMB) {
        super(titulo, fechaIncorporacion);
        this.numero = numero;
        this.nombreArchivo = nombreArchivo;
        this.pesoArchivoMB = pesoArchivoMB;
    }

    public int getNumero() {
        return this.numero;
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