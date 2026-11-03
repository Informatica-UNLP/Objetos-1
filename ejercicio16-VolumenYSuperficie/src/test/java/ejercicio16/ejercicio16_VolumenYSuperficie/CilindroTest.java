package ejercicio16.ejercicio16_VolumenYSuperficie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CilindroTest {
	
	
	@Test
	public void volumenRadioCero() {
		Cilindro cilindro = new Cilindro(0, 10, "Azul", "Hierro");
		assertEquals(0, cilindro.volumen());
	}
	
	@Test
	public void volumenRadioPositivo() {
		Cilindro cilindro = new Cilindro(2, 10, "Azul", "Hierro");
		assertEquals(40*Math.PI, cilindro.volumen());
	}
	
	@Test
	public void volumenAlturaCero() {
		Cilindro cilindro = new Cilindro(10, 0, "Azul", "Hierro");
		assertEquals(0, cilindro.volumen());
	}
	
	@Test
	public void volumenAlturaPositivo() {
		Cilindro cilindro = new Cilindro(10, 3, "Azul", "Hierro");
		assertEquals(300*Math.PI, cilindro.volumen());
	}
	
	
	@Test
	public void superficieRadioCero() {
		Cilindro cilindro = new Cilindro(0, 10, "Azul", "Hierro");
		assertEquals(0, cilindro.superficie());
	}
	
	@Test
	public void superficieRadioPositivo() {
		Cilindro cilindro = new Cilindro(2, 10, "Azul", "Hierro");
		assertEquals(48*Math.PI, cilindro.superficie());
	}
	
	@Test
	public void superficieAlturaCero() {
		Cilindro cilindro = new Cilindro(10, 0, "Azul", "Hierro");
		assertEquals(200*Math.PI, cilindro.superficie());
	}
	
	@Test
	public void superficieAlturaPositivo() {
		Cilindro cilindro = new Cilindro(10, 3, "Azul", "Hierro");
		assertEquals(260*Math.PI, cilindro.superficie());
	}
	
	
}