package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CancelacionModeradaTest {

	private CancelacionModerada politica;

	@BeforeEach
	void setUp() throws Exception {
		this.politica = new CancelacionModerada();
	}

	@Test
	public void testReembolsaTodoConMuchaAnticipacion() {
		assertEquals(500, this.politica.reembolso(500, 30), 0.001);
	}

	@Test
	public void testReembolsaTodoConSieteDias() {
		assertEquals(500, this.politica.reembolso(500, 7), 0.001);
	}

	@Test
	public void testReembolsaLaMitadConSeisDias() {
		assertEquals(250, this.politica.reembolso(500, 6), 0.001);
	}

	@Test
	public void testReembolsaLaMitadConTresDias() {
		assertEquals(250, this.politica.reembolso(500, 3), 0.001);
	}

	@Test
	public void testReembolsaLaMitadConDosDias() {
		assertEquals(250, this.politica.reembolso(500, 2), 0.001);
	}

	@Test
	public void testNoReembolsaConUnDia() {
		assertEquals(0, this.politica.reembolso(500, 1), 0.001);
	}
}