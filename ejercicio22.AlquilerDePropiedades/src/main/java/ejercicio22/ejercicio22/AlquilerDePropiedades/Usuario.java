package ejercicio22.ejercicio22.AlquilerDePropiedades;

import java.time.LocalDate;
import java.util.List;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

import java.util.ArrayList;


public class Usuario {

	private String nombre;
	private String direccion;
	private int DNI;
	private List <Reserva> reservas;
	private List <Propiedad> propiedades;
	
	public Usuario(String n, String d, int DNI) {
		this.nombre=n;
		this.direccion=d;
		this.DNI=DNI;
		this.reservas = new ArrayList <Reserva>();
		this.propiedades = new ArrayList <Propiedad>();
	}
	
	public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
	    DateLapse periodo = new DateLapse(fechaInicio, fechaFin);
	    return this.propiedades.stream()
	            .mapToDouble(propiedad -> propiedad.calcularIngresos(periodo))
	            .sum() * 0.75;
	}
	
	public Reserva reservar(Propiedad p, LocalDate fechaInicio, LocalDate fechaFin) {
		if (p.consultarDisponibilidad(fechaInicio, fechaFin)) {
			DateLapse periodo = new DateLapse(fechaInicio, fechaFin);
			Reserva r = new Reserva(p, periodo);
			p.agregarReserva(r);
			this.reservas.add(r);
			return r;
		}
		else {
			return null;
			}
		
	}
	
	public void cancelarReserva(Reserva r) {
	    if (!r.estaEnCurso()) {
	        r.getPropiedad().eliminarReserva(r);
	        this.reservas.remove(r);
	    }
	}
	
	public void agregarPropiedad(Propiedad p) {
		this.propiedades.add(p);
	}
	
	public void sacarPropiedad(Propiedad p) {
		this.propiedades.remove(p);
	}
	
	
}
