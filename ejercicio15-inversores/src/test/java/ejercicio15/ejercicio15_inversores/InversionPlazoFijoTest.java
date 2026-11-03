package ejercicio15.ejercicio15_inversores;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class InversionPlazoFijoTest{
	
	
	@Test
	public void testValorInicialCero() {
		InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(30), 0, 0.01);
		assertEquals(0, plazoFijo.valorActual());
	}
	
	@Test
	public void testValorInicialPositivo() {
		InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(30), 1000, 0.01);
		assertEquals(1300, plazoFijo.valorActual());
	}
	
	@Test
	public void testPorcentajeInteresCero() {
		InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(30), 1000, 0);
		assertEquals(1000, plazoFijo.valorActual());
	}
	
	@Test
	public void testFechaDeConstitucionHoy() {
		InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now(), 1000, 0.01);
		assertEquals(1000, plazoFijo.valorActual());
	}
	
	@Test
	public void testFechaDeConstitucionAyer() {
		InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(1), 1000, 0.01);
		assertEquals(1010, plazoFijo.valorActual());
	}
}