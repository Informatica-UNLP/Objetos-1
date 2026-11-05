package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CancelacionEstrictaTest {

	private CancelacionEstricta politica;

	@BeforeEach
	void setUp() throws Exception {
		this.politica = new CancelacionEstricta();
	}

	@Test
	public void testNoReembolsaNadaConMuchaAnticipacion() {
		assertEquals(0, this.politica.reembolso(500, 30), 0.001);
	}

	@Test
	public void testNoReembolsaNadaUnDiaAntes() {
		assertEquals(0, this.politica.reembolso(500, 1), 0.001);
	}
}