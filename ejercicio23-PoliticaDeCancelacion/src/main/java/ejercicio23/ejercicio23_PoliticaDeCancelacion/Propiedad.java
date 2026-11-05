package ejercicio23.ejercicio23_PoliticaDeCancelacion;
import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;
import java.time.LocalDate;
import java.util.List;



import java.util.ArrayList;

public class Propiedad {

	private String direccion;
	private String nombre;
	private double precio;
	private List <Reserva> reservas;
	private PoliticaDeCancelacion politica;
	
	
	public Propiedad(String d, String n, double p, PoliticaDeCancelacion politica) {
		this.direccion=d;
		this.nombre=n;
		this.precio=p;
		this.reservas = new ArrayList <Reserva>();
		this.politica = politica;
	}
	
	
	public boolean consultarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin) {
	    DateLapse periodo = new DateLapse(fechaInicio, fechaFin);
	    return this.reservas.stream()
	            .noneMatch(reserva -> reserva.seSuperponeCon(periodo));
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public PoliticaDeCancelacion getPolitica() {
		return this.politica;
	}
	
	public void agregarReserva(Reserva r) {
		this.reservas.add(r);
	}
	
	public void setPolitica(PoliticaDeCancelacion politica) {
		this.politica = politica;
	}
	
	public void eliminarReserva(Reserva r) {
		this.reservas.remove(r);
	}

	public double calcularIngresos(DateLapse periodo) {
	    return this.reservas.stream()
	            .filter(reserva -> reserva.estaIncluidaEn(periodo))
	            .mapToDouble(reserva -> reserva.calcularPrecio())
	            .sum();
	}
	
	
}
