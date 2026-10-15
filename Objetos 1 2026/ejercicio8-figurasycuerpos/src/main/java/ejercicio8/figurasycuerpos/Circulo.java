package ejercicio8.figurasycuerpos;

public class Circulo implements Cuerpo2D {

	private double radio;

	public Circulo() {
	}

	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDiametro() {
		return this.radio * 2;
	}

	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}

	public double getPerimetro() {
		return this.getDiametro() * Math.PI;
	}

	public double getArea() {
		return Math.PI * this.radio * this.radio;
	}
}