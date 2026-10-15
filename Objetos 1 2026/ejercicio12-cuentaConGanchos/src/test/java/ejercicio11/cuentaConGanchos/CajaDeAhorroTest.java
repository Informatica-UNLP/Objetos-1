package ejercicio11.cuentaConGanchos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


public class CajaDeAhorroTest {
	
	private CajaDeAhorro cajaDeAhorro;

	@BeforeEach
	public void setUp() {
		cajaDeAhorro = new CajaDeAhorro();
		cajaDeAhorro.depositar(100);		
	}
	
	@Test
	public void testDepositar() {
		assertEquals(98, cajaDeAhorro.getSaldo());	
	}
	@Test
	public void testExtraerSinFondosSuficientes() {
		assertFalse(cajaDeAhorro.extraer(100));
		assertEquals(98, cajaDeAhorro.getSaldo());	 //No tendria que chequear que es 98??? 
	}
	@Test
	public void testExtraerConFondosSuficientes() {		
		assertTrue(cajaDeAhorro.extraer(50));	
		assertEquals(47, cajaDeAhorro.getSaldo());	
	}
	
	@Test 
	public void testTransferirACuentaSinFondosSuficientes(){
		CajaDeAhorro destino = new CajaDeAhorro();
		assertEquals(98, cajaDeAhorro.getSaldo());
		assertFalse(cajaDeAhorro.transferirACuenta(98, destino));
		assertEquals(98, cajaDeAhorro.getSaldo());
		assertEquals(0, destino.getSaldo());
		}
	
	@Test
	public void testTransferirACuentaConFondosSuficientes(){
		CajaDeAhorro destino = new CajaDeAhorro();
		assertTrue(cajaDeAhorro.transferirACuenta(50, destino));
		assertEquals(47, cajaDeAhorro.getSaldo());
		assertEquals(49, destino.getSaldo());	
	}
	
	@Test 
	public void testTransferirACuentaCorrienteSinFondos() {
		CuentaCorriente destino = new CuentaCorriente();
		assertFalse(cajaDeAhorro.transferirACuenta(100, destino));
		assertEquals(98,cajaDeAhorro.getSaldo());
		assertEquals(0, destino.getSaldo());
	}
	
	@Test 
	public void testTransferirACuentaCorrienteConFondos() {
		CuentaCorriente destino = new CuentaCorriente();
		assertTrue(cajaDeAhorro.transferirACuenta(50, destino));
		assertEquals(47,cajaDeAhorro.getSaldo());
		assertEquals(50, destino.getSaldo());
	}
	
}