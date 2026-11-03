package ejercicio16.ejercicio16_VolumenYSuperficie;

public abstract class Pieza {
	

	private String material;
	private String color;
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public abstract double volumen();
	
	public abstract double superficie();
	


}
