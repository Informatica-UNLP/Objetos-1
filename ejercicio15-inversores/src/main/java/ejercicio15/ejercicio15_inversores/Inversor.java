package ejercicio15.ejercicio15_inversores;
import java.util.ArrayList;
import  java.util.List;

public class Inversor{
	
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String n) {
		this.nombre = n;
		this.inversiones = new ArrayList<Inversion> ();
	}
	
	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}
	public void sacarInversion(Inversion i) {
		this.inversiones.remove(i);
	}
	
	public double valorInversiones() {
		return this.inversiones.stream().mapToDouble(inversion->inversion.valorActual()).sum(); 
	}
} 


