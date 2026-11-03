package ejercicio16.ejercicio16_VolumenYSuperficie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EsferaTest {
	
	@Test
	public void volumenRadioCero() {
		Esfera esfera = new Esfera(0, "Azul", "Hierro");
		assertEquals(0, esfera.volumen());
	}
	
	@Test
	public void volumenRadioPositivo() {
		Esfera esfera = new Esfera(3, "Azul", "Hierro");
		assertEquals(36*Math.PI, esfera.volumen(), 0.001);
	}

	@Test
	public void superficieRadioCero() {
		Esfera esfera = new Esfera(0, "Azul", "Hierro");
		assertEquals(0, esfera.superficie());
	}
	
	@Test
	public void superficieRadioPositivo() {
		Esfera esfera = new Esfera(3, "Azul", "Hierro");
		assertEquals(36*Math.PI, esfera.superficie());
	}
}