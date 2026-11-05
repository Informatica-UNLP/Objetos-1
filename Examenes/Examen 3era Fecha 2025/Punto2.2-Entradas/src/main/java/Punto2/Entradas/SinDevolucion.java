package Punto2.Entradas;

import java.time.LocalDate;

public class SinDevolucion implements PoliticaDeReembolso {

	@Override
	public double calcularReembolso(Entrada entrada, LocalDate fechaCancelacion) {
		return 0;
	}
}