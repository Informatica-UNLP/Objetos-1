package ejercicio17.ejercicio17_ClienteDeCorreo;

import java.util.List;
import java.util.ArrayList;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("Inbox");
		this.carpetas = new ArrayList<Carpeta>();
		this.carpetas.add(this.inbox);
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
	
	public void agregarCarpeta(Carpeta carpeta) { 
		this.carpetas.add(carpeta);
	}
	
	public void sacarCarpeta(Carpeta carpeta) {
		if (carpeta != this.inbox) {
			this.carpetas.remove(carpeta);
		}
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public Email buscar(String texto){
		return this.carpetas.stream()
				.map(carpeta -> carpeta.buscar(texto))
				.filter(email -> email != null)
				.findFirst()
				.orElse(null);
	}
	
	public int espacioOcupado() {
		return carpetas.stream().mapToInt(carpeta->carpeta.espacioOcupado())
				 .sum(); 
	}
	
	

	
}
