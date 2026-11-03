package ejercicio19.ejercicio19_IntervaloDeTiempo2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DateLapse {

	private LocalDate from;
	private int sizeInDays;
	
	
	public DateLapse(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}	

	public LocalDate getTo() {
		return this.from.plusDays(sizeInDays);
	}
	

	public int sizeInDays() {
	 return this.sizeInDays;
	}
	


	public boolean includesDate(LocalDate other) {
		return !other.isBefore(this.from) && !other.isAfter(this.getTo());
	}

}
