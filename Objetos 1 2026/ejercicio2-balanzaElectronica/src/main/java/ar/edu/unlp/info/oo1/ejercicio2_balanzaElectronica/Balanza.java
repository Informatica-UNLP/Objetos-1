package ar.edu.unlp.info.oo1.ejercicio2_balanzaElectronica;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	
	public Balanza() {
		this.ponerEnCero();
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public void ponerEnCero(){
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public void agregarProducto(Producto P) {
		this.cantidadDeProductos++;
	    this.precioTotal += P.getPrecio();
	    this.pesoTotal += P.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket T =  new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
		this.ponerEnCero();
		return T;
	}
}

