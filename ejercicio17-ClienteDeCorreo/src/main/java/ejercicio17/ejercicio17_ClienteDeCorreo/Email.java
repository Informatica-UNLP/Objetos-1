package ejercicio17.ejercicio17_ClienteDeCorreo;

import java.util.List;
import java.util.ArrayList;

public class Email {

	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public boolean contiene(String texto) {		
		return this.titulo.contains(texto) || this.cuerpo.contains(texto);
	}
	
	public void agregarAdjunto(Archivo a) {
		this.adjuntos.add(a);
	}
	
	public void sacarAdjunto(Archivo a) {
		this.adjuntos.remove(a);
	}
	
	public int tamanio() {
		int tamanio = this.titulo.length() + this.cuerpo.length();
		tamanio += adjuntos.stream().mapToInt(adjunto->adjunto.tamanio())
		 .sum(); 
		return tamanio;
	}
	
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}

	
}
