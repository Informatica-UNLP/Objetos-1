package ar.edu.unlp.info.oo1.ejercicio7_balanzaElectronica;

public class Producto {
	
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	
	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.descripcion = descripcion;
		this.peso = peso;
		this.precioPorKilo = precioPorKilo;
	}
	
	public double getPrecio() {
		double precio;
		precio = this.precioPorKilo * this.peso;
		return precio;
	}
	
	
	public double getPeso() {
		return this.peso;
	}
	
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
