package ejercicio15.ejercicio15_inversores;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InversionAccionesTest{
	
	
	
	@Test 
	public void testValorUnitarioCero() {
		InversionAcciones inversionAcciones = new InversionAcciones(new Accion(0, "YPF"), 10);
		assertEquals(0, inversionAcciones.valorActual());
	}
	
	@Test 
	public void testCantidadCero() {
		InversionAcciones inversionAcciones = new InversionAcciones(new Accion(10, "YPF"), 0);
		assertEquals(0, inversionAcciones.valorActual());
	}
	
	@Test 
	public void testCantidadUna() {
		InversionAcciones inversionAcciones = new InversionAcciones(new Accion(10, "YPF"), 1);
		assertEquals(10, inversionAcciones.valorActual());
	}
	
	@Test 
	public void testCantidadVarias() {
		InversionAcciones inversionAcciones = new InversionAcciones(new Accion(10, "YPF"), 10);
		assertEquals(100, inversionAcciones.valorActual());
	}
	
}