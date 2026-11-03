package ejercicio16.ejercicio16_VolumenYSuperficie;

public class Cilindro extends Pieza{

	private double radio;
	private double altura;
	
	public Cilindro(double r, double h, String c, String m) {
		this.radio = r;
		this.altura = h;
		this.setMaterial(m);
		this.setColor(c);
	}
	
	@Override
	public double volumen() {
		double volumen = Math.PI * Math.pow(this.radio, 2) * this.altura;
		return volumen;
	}
	
	@Override
	public double superficie() {
		double superficie = 2 * Math.PI * this.radio * this.altura + 2 * Math.PI * Math.pow(this.radio, 2);
		return superficie;
	}
	
}
