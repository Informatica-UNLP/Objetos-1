package ejercicio15.ejercicio15_inversores;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InversionPlazoFijo implements Inversion{
	private double valorInicial;
	private double porcentajeInteres;
	private LocalDate fechaConstitucion; 
	
	
	public InversionPlazoFijo(LocalDate fechaConstitucion, double valorInicial, double porcentajeInteres) {
		this.fechaConstitucion = fechaConstitucion;
		this.valorInicial = valorInicial;
		this.porcentajeInteres = porcentajeInteres;
	}
	
	@Override
	public double valorActual() {
		long cantDias = ChronoUnit.DAYS.between(this.fechaConstitucion, LocalDate.now());
		double interesDiario = this.valorInicial * this.porcentajeInteres;
		return this.valorInicial + interesDiario * cantDias;
	}

}
