package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class UsuarioTest {

	private Usuario huesped;
	private Propiedad propiedad;
	private LocalDate hoy;

	@BeforeEach
	void setUp() throws Exception {
		this.huesped = new Usuario("Beto", "Calle 2", 22222222);
		this.propiedad = new Propiedad("Calle 1", "Casa", 100, new CancelacionFlexible());
		this.hoy = LocalDate.now();
	}

	@Test
	public void testCancelarReservaFuturaConPoliticaFlexible() {
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(10), this.hoy.plusDays(15));
		assertFalse(this.propiedad.consultarDisponibilidad(this.hoy.plusDays(10), this.hoy.plusDays(15)));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(500, reembolso, 0.001);
		assertTrue(this.propiedad.consultarDisponibilidad(this.hoy.plusDays(10), this.hoy.plusDays(15)));
	}

	@Test
	public void testCancelarReservaFuturaConPoliticaEstricta() {
		this.propiedad.setPolitica(new CancelacionEstricta());
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(10), this.hoy.plusDays(15));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(0, reembolso, 0.001);
		assertTrue(this.propiedad.consultarDisponibilidad(this.hoy.plusDays(10), this.hoy.plusDays(15)));
	}

	@Test
	public void testCancelarReservaConPoliticaModeradaConMuchaAnticipacion() {
		this.propiedad.setPolitica(new CancelacionModerada());
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(10), this.hoy.plusDays(15));

		assertEquals(500, this.huesped.cancelarReserva(reserva), 0.001);
	}

	@Test
	public void testCancelarReservaConPoliticaModeradaReembolsaLaMitad() {
		this.propiedad.setPolitica(new CancelacionModerada());
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(5), this.hoy.plusDays(8));

		assertEquals(150, this.huesped.cancelarReserva(reserva), 0.001);
	}

	@Test
	public void testCancelarReservaConPoliticaModeradaUnDiaAntesNoReembolsaPeroCancela() {
		this.propiedad.setPolitica(new CancelacionModerada());
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(1), this.hoy.plusDays(4));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(0, reembolso, 0.001);
		assertTrue(this.propiedad.consultarDisponibilidad(this.hoy.plusDays(1), this.hoy.plusDays(4)));
	}

	@Test
	public void testCambiarLaPoliticaCambiaElReembolso() {
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.plusDays(10), this.hoy.plusDays(15));
		this.propiedad.setPolitica(new CancelacionEstricta());

		assertEquals(0, this.huesped.cancelarReserva(reserva), 0.001);
	}

	@Test
	public void testCancelarReservaEnCursoNoSeCancela() {
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.minusDays(1), this.hoy.plusDays(1));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(0, reembolso, 0.001);
		assertFalse(this.propiedad.consultarDisponibilidad(this.hoy.minusDays(1), this.hoy.plusDays(1)));
	}

	@Test
	public void testCancelarReservaQueEmpiezaHoyNoSeCancela() {
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy, this.hoy.plusDays(3));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(0, reembolso, 0.001);
		assertFalse(this.propiedad.consultarDisponibilidad(this.hoy, this.hoy.plusDays(3)));
	}

	@Test
	public void testCancelarReservaYaTerminadaNoReembolsaNiCancela() {
		Reserva reserva = this.huesped.reservar(this.propiedad, this.hoy.minusDays(4), this.hoy.minusDays(1));

		double reembolso = this.huesped.cancelarReserva(reserva);

		assertEquals(0, reembolso, 0.001);
		assertFalse(this.propiedad.consultarDisponibilidad(this.hoy.minusDays(4), this.hoy.minusDays(1)));
	}

	@Test
	public void testCancelarReservaQueNuncaSeAgrego() {
		this.huesped.reservar(this.propiedad, this.hoy.plusDays(10), this.hoy.plusDays(15));
		Reserva ajena = new Reserva(this.propiedad, new DateLapse(this.hoy.plusDays(20), this.hoy.plusDays(25)));

		double reembolso = this.huesped.cancelarReserva(ajena);

		assertEquals(0, reembolso, 0.001);
		assertFalse(this.propiedad.consultarDisponibilidad(this.hoy.plusDays(10), this.hoy.plusDays(15)));
	}
}