package Punto2.Entradas;

import java.time.LocalDate;

public class Entrada {
	private double precioPagado;
	private LocalDate fechaCompra;
	private LocalDate fechaEvento;
	private PoliticaDeReembolso politica;

	public Entrada(double precioPagado, LocalDate fechaCompra, LocalDate fechaEvento, PoliticaDeReembolso politica) {
		this.precioPagado = precioPagado;
		this.fechaCompra = fechaCompra;
		this.fechaEvento = fechaEvento;
		this.politica = politica;
	}

	public double getPrecioPagado() { return this.precioPagado; }
	public LocalDate getFechaCompra() { return this.fechaCompra; }
	public LocalDate getFechaEvento() { return this.fechaEvento; }

	public void setPolitica(PoliticaDeReembolso politica) {
		this.politica = politica;
	}

	public double calcularReembolso(LocalDate fechaCancelacion) {
		return this.politica.calcularReembolso(this, fechaCancelacion);
	}
}