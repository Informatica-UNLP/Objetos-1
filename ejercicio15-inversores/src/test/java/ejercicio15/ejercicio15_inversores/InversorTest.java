package ejercicio15.ejercicio15_inversores;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InversorTest {
	private Inversor inversor;
	
	@BeforeEach
	void setUp() throws Exception {
		inversor = new Inversor("Warren");
	}
	
    @Test
	public void testInversorCarteraVacia() {
		assertEquals(0, inversor.valorInversiones());
	}
    
	@Test
	public void testInversorUnaInversion() {
		inversor.agregarInversion(new InversionAcciones(new Accion(100, "YPF"), 10));
		assertEquals(1000, inversor.valorInversiones());
	}
	
	@Test 
	public void testInversorCarteraMezclada(){
		inversor.agregarInversion(new InversionAcciones(new Accion(100, "YPF"), 10));
		inversor.agregarInversion(new InversionPlazoFijo(LocalDate.now(),10, 0.01));
		assertEquals(1010, inversor.valorInversiones());
	}
	
	@Test
	public void testInversorSacarInversionExistente() {
		Inversion accion = new InversionAcciones(new Accion(100, "YPF"), 10);
		Inversion plazoFijo = new InversionPlazoFijo(LocalDate.now(),10, 0.01);
		inversor.agregarInversion(accion);
		inversor.agregarInversion(plazoFijo);

		inversor.sacarInversion(accion);

		assertEquals(10, inversor.valorInversiones());
	}
	@Test
	public void testInversorSacarInversionInexistente() {
		inversor.agregarInversion(new InversionAcciones(new Accion(100, "YPF"), 10));

		inversor.sacarInversion(new InversionAcciones(new Accion(10, "YPF"), 10)); 

		assertEquals(1000, inversor.valorInversiones());
	}
	
	@Test
	public void testInversorSacarLaUnicaInversion() {
		Inversion acciones = new InversionAcciones(new Accion(100, "YPF"), 10);
		inversor.agregarInversion(acciones);

		inversor.sacarInversion(acciones);

		assertEquals(0, inversor.valorInversiones());
	}

}
