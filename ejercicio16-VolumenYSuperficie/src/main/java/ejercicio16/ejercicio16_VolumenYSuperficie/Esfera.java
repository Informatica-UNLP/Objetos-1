package ejercicio16.ejercicio16_VolumenYSuperficie;

public class Esfera extends Pieza{
	
	private double radio;
	

	public Esfera(double r, String c, String m) {
		this.radio = r;
		this.setMaterial(m);
		this.setColor(c);
	}
	
	@Override
	public double volumen() {
		double volumen = 4.0 / 3 * Math.PI * Math.pow(this.radio, 3);
		return volumen;
	}
	
	@Override
	public double superficie() {
		double superficie = 4 * Math.PI * Math.pow(this.radio, 2);
		return superficie;
	}
}
