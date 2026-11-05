package ejercicio18.ejercicio18_IntervaloDeTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DateLapse {

	private LocalDate from;
	private LocalDate to;
	
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}	

	public LocalDate getTo() {
		return this.to;
	}
	

	public int sizeInDays() {
	 return (int) this.from.until(this.to, ChronoUnit.DAYS);
	}
	
	public boolean overlaps(DateLapse anotherDateLapse) {
	    return this.from.isBefore(anotherDateLapse.getTo())
	        && anotherDateLapse.getFrom().isBefore(this.to);
	}

	public boolean includesDate(LocalDate other) {
		return !other.isBefore(this.from) && !other.isAfter(this.to);
	}

}
