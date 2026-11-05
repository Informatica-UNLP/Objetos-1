package Punto2.Entradas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Flexible implements PoliticaDeReembolso {
	private double precioSeguro;

	public Flexible(double precioSeguro) {
		this.precioSeguro = precioSeguro;
	}

	@Override
	public double calcularReembolso(Entrada entrada, LocalDate fechaCancelacion) {
		long diasDesdeCompra = ChronoUnit.DAYS.between(entrada.getFechaCompra(), fechaCancelacion);
		long diasRestantes = ChronoUnit.DAYS.between(fechaCancelacion, entrada.getFechaEvento());
		if (diasRestantes <= 0) {
			return 0;
		}
		if (diasDesdeCompra < 3) {
			return entrada.getPrecioPagado() + this.precioSeguro;
		}
		return entrada.getPrecioPagado() * 0.5;
	}
}