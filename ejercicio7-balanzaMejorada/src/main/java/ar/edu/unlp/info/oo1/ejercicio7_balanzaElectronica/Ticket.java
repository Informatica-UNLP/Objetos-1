package ar.edu.unlp.info.oo1.ejercicio7_balanzaElectronica;
import java.time.LocalDate;

public class Ticket {
	private  java.time.LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;

	
	public Ticket( int cantidadDeProductos, double pesoTotal, double precioTotal ) {
		this.fecha =  LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
	}
	
	public double impuesto() {
		double impuesto = this.precioTotal * 0.21;
		return impuesto;
	}
	
	public java.time.LocalDate getFecha(){
		return this.fecha;
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
}
