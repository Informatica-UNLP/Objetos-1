package Punto2.Entradas;

import java.time.LocalDate;

public interface PoliticaDeReembolso {
	double calcularReembolso(Entrada entrada, LocalDate fechaCancelacion);
}