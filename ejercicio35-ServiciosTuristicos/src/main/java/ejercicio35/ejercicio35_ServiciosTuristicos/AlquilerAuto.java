package ejercicio35.ejercicio35_ServiciosTuristicos;

import java.time.LocalDate;

public class AlquilerAuto extends ServicioContratado {
	private double costoPorKm, kilometrosRecorridos, costoDiarioSeguro;
	private String tipoVehiculo;

	public AlquilerAuto(double costoPorKm, double kilometrosRecorridos, LocalDate fechaInicio, LocalDate fechaFin, String tipoVehiculo, double costoDiarioSeguro) {
		super(fechaInicio, fechaFin);
		this.costoPorKm = costoPorKm;
		this.kilometrosRecorridos = kilometrosRecorridos;
		this.costoDiarioSeguro = costoDiarioSeguro;
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public double calcularPrecio() {
		return (this.costoPorKm * this.kilometrosRecorridos) + (this.costoDiarioSeguro * this.cantidadDeDias());
	}
}