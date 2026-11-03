package ejercicio17.ejercicio17_ClienteDeCorreo;
import java.util.List;
import java.util.ArrayList;


public class Carpeta {
	
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void sacarEmail(Email email) {
		this.emails.remove(email);
	}
	
	public void mover(Email email, Carpeta carpeta) {
		this.sacarEmail(email);
		carpeta.agregarEmail(email);
	}
	
	public int espacioOcupado() {
		return emails.stream().mapToInt(email->email.tamanio())
		 .sum(); 
	}
	
	public Email buscar(String texto) {
		return this.emails.stream()
				.filter(email -> email.contiene(texto))
				.findFirst()
				.orElse(null);
	}
}
