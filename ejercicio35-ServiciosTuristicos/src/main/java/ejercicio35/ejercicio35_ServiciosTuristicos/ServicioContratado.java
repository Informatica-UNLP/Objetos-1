package ejercicio35.ejercicio35_ServiciosTuristicos;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ServicioContratado {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ServicioContratado(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    protected long cantidadDeDias() {
        return ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
    }

    public abstract double calcularPrecio();
}