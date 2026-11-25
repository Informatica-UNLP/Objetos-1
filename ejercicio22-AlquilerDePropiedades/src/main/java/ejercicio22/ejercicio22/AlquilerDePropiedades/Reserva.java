package ejercicio22.ejercicio22.AlquilerDePropiedades;

import java.time.LocalDate;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class Reserva {

	private DateLapse periodo;
	private Propiedad propiedad;

	public Reserva(Propiedad propiedad, DateLapse periodo) {
		this.propiedad = propiedad;
		this.periodo = periodo;	
	}
	
	public Propiedad getPropiedad(){
		return this.propiedad;
	}
	
	public boolean estaIncluidaEn(DateLapse otro) {
		return otro.includesDate(this.periodo.getFrom())
			&& otro.includesDate(this.periodo.getTo());
	}

	public boolean seSuperponeCon(DateLapse otro) {
		return this.periodo.overlaps(otro);
	}

	public double calcularPrecio() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecio();
	}

	public boolean estaEnCurso() {
		return this.periodo.includesDate(LocalDate.now());
	}
}