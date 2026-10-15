package ejercicio11.cuentaConGanchos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class CuentaCorrienteTest {
	
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	public void setUp() {
		cuentaCorriente = new CuentaCorriente();
		
	}
	
	@Test
	public void testDepositar() {
		cuentaCorriente.depositar(100);
		assertEquals(100, cuentaCorriente.getSaldo());
	}
	
	@Test
	public void testExtraerConLimite() {
		cuentaCorriente.setDescubierto(500);
		assertTrue(cuentaCorriente.extraer(300));
		assertEquals(-300, cuentaCorriente.getSaldo());
		
	}
	
	@Test
	public void testExtraerSinLimite() {
		cuentaCorriente.setDescubierto(500);	
		assertFalse(cuentaCorriente.extraer(600));
		assertEquals(0, cuentaCorriente.getSaldo());
		
	}
	
	@Test
	public void testTransferirACuentaSinLimite() {
		CuentaCorriente destino = new CuentaCorriente();
		cuentaCorriente.setDescubierto(200);
		assertFalse(cuentaCorriente.transferirACuenta(300, destino));
		assertEquals(0, cuentaCorriente.getSaldo());
		assertEquals(0, destino.getSaldo());
	}
	
	@Test
	public void testTransferirACuentaConLimite() {
		CuentaCorriente destino = new CuentaCorriente();
		cuentaCorriente.setDescubierto(200);
		assertTrue(cuentaCorriente.transferirACuenta(100, destino));
		assertEquals(-100, cuentaCorriente.getSaldo());
		assertEquals(100, destino.getSaldo());
	}
	
	@Test 
	public void testTransferirACuentaCorrienteSinFondos() {
		CajaDeAhorro destino = new CajaDeAhorro();
		cuentaCorriente.setDescubierto(200);
		assertFalse(cuentaCorriente.transferirACuenta(300, destino));
		assertEquals(0 ,cuentaCorriente.getSaldo());
		assertEquals(0, destino.getSaldo());
	}
	
	@Test 
	public void testTransferirACuentaCorrienteConFondos() {
		CajaDeAhorro destino = new CajaDeAhorro();
		cuentaCorriente.setDescubierto(200);
		assertTrue(cuentaCorriente.transferirACuenta(200, destino));
		assertEquals(-200 ,cuentaCorriente.getSaldo());
		assertEquals(196, destino.getSaldo());
	}
	
}
