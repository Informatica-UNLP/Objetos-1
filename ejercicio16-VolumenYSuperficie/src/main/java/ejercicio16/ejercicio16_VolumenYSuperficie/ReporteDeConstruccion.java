package ejercicio16.ejercicio16_VolumenYSuperficie;
import java.util.List;
import java.util.ArrayList;

public class ReporteDeConstruccion {
	
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}

	public void agregarPieza(Pieza p) {
		this.piezas.add(p);
	}
	
	public void sacarPieza(Pieza p) {
		this.piezas.remove(p);
	}
	
	public double volumenDeMaterial(String material){
		return this.piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.mapToDouble(pieza -> pieza.volumen())
				.sum();
	}
	public double superficieDeColor(String color) {
		return this.piezas.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(pieza -> pieza.superficie())
				.sum();
	}
}
