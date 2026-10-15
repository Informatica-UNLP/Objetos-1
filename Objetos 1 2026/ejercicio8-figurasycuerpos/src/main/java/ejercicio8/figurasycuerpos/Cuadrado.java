package ejercicio8.figurasycuerpos;

public class Cuadrado implements Cuerpo2D {
	
	private double lado;

	public Cuadrado() {
		
	}
	
	public void setLado(double l) {
		this.lado = l;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getArea() {
		double area = Math.pow(lado, 2);
		return area;
	}
	
	public double getPerimetro() {
		double perimetro = this.lado * 4;
		return perimetro;
	}
}
