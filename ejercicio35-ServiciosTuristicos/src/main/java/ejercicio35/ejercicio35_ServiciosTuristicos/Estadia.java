package ejercicio35.ejercicio35_ServiciosTuristicos;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Estadia extends ServicioContratado {
	private String destino;
	private double costoPorDia;
	private int cantidadPersonas;

	public Estadia(String destino, double costoPorDia, LocalDate fechaInicio, LocalDate fechaFin, int cantidadPersonas) {
		super(fechaInicio, fechaFin);
		this.destino = destino;
		this.costoPorDia = costoPorDia;
		this.cantidadPersonas = cantidadPersonas;
	}

	@Override
	public double calcularPrecio() {
		return this.cantidadDeDias() * this.costoPorDia * this.cantidadPersonas;
	}
}
	
