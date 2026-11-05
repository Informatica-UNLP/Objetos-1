package ejercicio23.ejercicio23_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class PropiedadTest {

	private Propiedad propiedad;

	@BeforeEach
	void setUp() throws Exception {
		this.propiedad = new Propiedad("Calle 1", "Casa", 100, new CancelacionFlexible());
		this.propiedad.agregarReserva(new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15))));
	}

	@Test
	public void testDisponibilidadSinReservas() {
		Propiedad vacia = new Propiedad("Calle 2", "Depto", 50, new CancelacionFlexible());

		assertTrue(vacia.consultarDisponibilidad(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15)));
	}

	@Test
	public void testDisponibilidadTerminaCuandoEmpiezaLaReserva() {
		assertTrue(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 5), LocalDate.of(2030, 3, 10)));
	}

	@Test
	public void testDisponibilidadEmpiezaCuandoTerminaLaReserva() {
		assertTrue(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 15), LocalDate.of(2030, 3, 20)));
	}

	@Test
	public void testNoDisponibleSePisaConElComienzo() {
		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 5), LocalDate.of(2030, 3, 12)));
	}

	@Test
	public void testNoDisponibleSePisaConElFinal() {
		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 12), LocalDate.of(2030, 3, 20)));
	}

	@Test
	public void testNoDisponiblePedidoDentroDeLaReserva() {
		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 11), LocalDate.of(2030, 3, 14)));
	}

	@Test
	public void testNoDisponiblePedidoContieneALaReserva() {
		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 5), LocalDate.of(2030, 3, 20)));
	}

	@Test
	public void testDisponibleEnElHuecoEntreDosReservas() {
		this.propiedad.agregarReserva(new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25))));

		assertTrue(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 16), LocalDate.of(2030, 3, 19)));
	}

	@Test
	public void testNoDisponibleCaeEnLaSegundaReserva() {
		this.propiedad.agregarReserva(new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25))));

		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 22), LocalDate.of(2030, 3, 24)));
	}

	@Test
	public void testIngresosPeriodoQueIncluyeTodasLasReservas() {
		this.propiedad.agregarReserva(new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25))));
		DateLapse marzo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31));

		assertEquals(1000, this.propiedad.calcularIngresos(marzo), 0.001);
	}

	@Test
	public void testIngresosPeriodoQueIncluyeSoloUnaReserva() {
		this.propiedad.agregarReserva(new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25))));
		DateLapse periodo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 17));

		assertEquals(500, this.propiedad.calcularIngresos(periodo), 0.001);
	}

	@Test
	public void testIngresosReservaParcialmenteIncluidaNoCuenta() {
		DateLapse periodo = new DateLapse(LocalDate.of(2030, 3, 12), LocalDate.of(2030, 3, 31));

		assertEquals(0, this.propiedad.calcularIngresos(periodo), 0.001);
	}

	@Test
	public void testIngresosPeriodoIgualALaReserva() {
		DateLapse periodo = new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15));

		assertEquals(500, this.propiedad.calcularIngresos(periodo), 0.001);
	}

	@Test
	public void testIngresosSinReservasEnElPeriodo() {
		DateLapse periodo = new DateLapse(LocalDate.of(2030, 4, 1), LocalDate.of(2030, 4, 30));

		assertEquals(0, this.propiedad.calcularIngresos(periodo), 0.001);
	}
}