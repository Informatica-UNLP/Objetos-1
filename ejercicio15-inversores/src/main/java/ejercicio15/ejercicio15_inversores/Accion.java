package ejercicio15.ejercicio15_inversores;

public class Accion {
	private double valorUnitario;
	private String nombre;
	
	
	public Accion(double valorUnitario, String nombre){
		this.valorUnitario = valorUnitario;
		this.nombre = nombre;
	}
	
	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public String getNombre() {
		return this.nombre;
	}
}
