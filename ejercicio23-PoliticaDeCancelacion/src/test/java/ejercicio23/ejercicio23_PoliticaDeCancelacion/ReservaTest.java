package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class ReservaTest {

	private Propiedad propiedad;

	@BeforeEach
	void setUp() throws Exception {
		this.propiedad = new Propiedad("Calle 1", "Casa", 100, new CancelacionFlexible());
	}

	@Test
	public void testDiasHastaElInicioDeUnaReservaFutura() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.plusDays(10), hoy.plusDays(15)));

		assertEquals(10, reserva.diasHastaElInicio());
	}

	@Test
	public void testDiasHastaElInicioEmpiezaManiana() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.plusDays(1), hoy.plusDays(4)));

		assertEquals(1, reserva.diasHastaElInicio());
	}

	@Test
	public void testDiasHastaElInicioEmpiezaHoy() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy, hoy.plusDays(3)));

		assertEquals(0, reserva.diasHastaElInicio());
	}

	@Test
	public void testDiasHastaElInicioEmpezoAyer() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.minusDays(1), hoy.plusDays(3)));

		assertEquals(-1, reserva.diasHastaElInicio());
	}
}