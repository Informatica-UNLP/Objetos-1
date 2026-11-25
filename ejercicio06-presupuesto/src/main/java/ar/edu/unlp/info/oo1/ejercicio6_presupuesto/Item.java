package ar.edu.unlp.info.oo1.ejercicio6_presupuesto;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item(String detalle, int cantidad, double costoUnitario ) {
		this.cantidad = cantidad;
		this.detalle = detalle;
		this.costoUnitario = costoUnitario;
	}
	
	public double costo() {
		double total = this.costoUnitario * this.cantidad;
		return total;
	}
	public double getCostoUnitario() {
		return this.costoUnitario;
	}
}
