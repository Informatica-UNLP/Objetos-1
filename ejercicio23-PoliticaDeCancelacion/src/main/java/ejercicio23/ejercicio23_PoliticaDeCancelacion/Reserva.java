package ejercicio23.ejercicio23_PoliticaDeCancelacion;
import java.time.temporal.ChronoUnit;
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

	public DateLapse getPeriodo() {
		return this.periodo;
	};
	
	public boolean seSuperponeCon(DateLapse otro) {
		return this.periodo.overlaps(otro);
	}

	public double calcularPrecio() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecio();
	}

	public boolean estaEnCurso() {
		return this.periodo.includesDate(LocalDate.now());
	}
	public int diasHastaElInicio() {
	    return (int) LocalDate.now().until(this.periodo.getFrom(), ChronoUnit.DAYS);
	}
}