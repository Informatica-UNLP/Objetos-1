package ar.edu.unlp.info.oo1.ejercicio7_balanzaElectronica;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
	private List <Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList <Producto> ();
	}
	
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPrecioTotal() {
		double precioTotal = 0;
		for (Producto producto : productos) {
			precioTotal += producto.getPrecio();
		}
		return precioTotal;
	}
	
	public double getPesoTotal() {
		double pesoTotal =  0;
		for (Producto producto : productos) {
			pesoTotal+= producto.getPeso();
		} //cambiar a streams
		return pesoTotal;
	}
	
	public void ponerEnCero(){
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		Ticket ticket =  new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
		this.ponerEnCero();
		return ticket;
	}
}

