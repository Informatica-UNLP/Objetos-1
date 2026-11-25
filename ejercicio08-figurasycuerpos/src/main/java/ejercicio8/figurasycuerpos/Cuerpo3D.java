package ejercicio8.figurasycuerpos;

public class Cuerpo3D {
	private Cuerpo2D caraBasal;
	private double altura;
	
	public Cuerpo3D() {
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Cuerpo2D cara) {
		this.caraBasal = cara;
	}
	public Cuerpo2D getCaraBasal() {
		return this.caraBasal;
	}
	
	public double getVolumen() {
		double volumen = this.caraBasal.getArea() * this.altura;
		return volumen;
	}
	public double getSuperficieExterior() {
		double supExt = 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
		return supExt;
	}
}
