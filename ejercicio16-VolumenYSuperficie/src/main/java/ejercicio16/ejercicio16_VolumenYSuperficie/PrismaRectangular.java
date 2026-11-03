package ejercicio16.ejercicio16_VolumenYSuperficie;

public class PrismaRectangular extends Pieza{

	private double ladoMayor;
	private double ladoMenor;
	private double altura;
	
	public PrismaRectangular(double ladoMenor, double ladoMayor, double altura, String c, String m) {
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
		this.setMaterial(m);
		this.setColor(c);
	}
	
	@Override 
	public double volumen() {
		double volumen = this.ladoMayor * this.ladoMenor * altura;
		return volumen;
	}
	
	@Override
	public double superficie() {
		double superficie = 2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * this.altura);
		return superficie;
	}
	
}
