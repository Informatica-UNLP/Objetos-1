package ar.edu.unlp.info.oo1.ejercicio6_presupuesto;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private List<Item>items; 
	
	public Presupuesto(String cliente) {
		this.items = new ArrayList<Item>();
		this.cliente= cliente;
		this.fecha = LocalDate.now();
	}
	
	public void agregarItem(Item nuevoItem) {
		this.items.add(nuevoItem);
	}
	
	public double calcularTotal() {
		double total=0;
		for(Item item : items) {
			total += item.costo();
		}
		return total;
	}
	public LocalDate getFecha() {
		return this.fecha;
	}
	public String getCliente() {
		return this.cliente;
	}
}
