package ejercicio35.ejercicio35_ServiciosTuristicos;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
	  private String nombre;
	  private List<ServicioContratado> serviciosContratados;

	  public Usuario(String nombre) {
	    this.nombre = nombre;
	    this.serviciosContratados = new ArrayList<>();
	  }
	  public void agregarServicio(ServicioContratado servicio){ 
	    this.serviciosContratados.add(servicio); 
	  }
	 
	  public double calcularGastoTotal() {
	    return this.serviciosContratados.stream().mapToDouble(servicio->servicio.calcularPrecio()).sum();
	  }  
	  
}

