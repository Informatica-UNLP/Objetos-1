package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CancelacionFlexibleTest {

	private CancelacionFlexible politica;

	@BeforeEach
	void setUp() throws Exception {
		this.politica = new CancelacionFlexible();
	}

	@Test
	public void testReembolsaTodoConMuchaAnticipacion() {
		assertEquals(500, this.politica.reembolso(500, 30), 0.001);
	}

	@Test
	public void testReembolsaTodoUnDiaAntes() {
		assertEquals(500, this.politica.reembolso(500, 1), 0.001);
	}
}