package ejercicio15.ejercicio15_inversores;


public class InversionAcciones implements Inversion{
	
	private int cantidadAccion;
	private Accion accion;
	
	
	public InversionAcciones(Accion a, int cantA) {
		this.accion = a;
		this.cantidadAccion = cantA;		
	}
	
	@Override
	public double valorActual() {
		double valorActual = accion.getValorUnitario() * this.cantidadAccion;
		return valorActual;	
	}
	
}