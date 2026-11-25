package ejercicio22.ejercicio22.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class UsuarioTest {

	private Usuario propietario;
	private Usuario huesped;
	private Propiedad propiedad;

	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Usuario("Ana", "Calle 1", 11111111);
		this.huesped = new Usuario("Beto", "Calle 2", 22222222);
		this.propiedad = new Propiedad("Calle 1", "Casa", 100);
		this.propietario.agregarPropiedad(this.propiedad);
		this.huesped.reservar(this.propiedad, LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15));
	}

	@Test
	public void testReservarPropiedadDisponible() {
		Reserva reserva = this.huesped.reservar(this.propiedad, LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25));

		assertNotNull(reserva);
		assertEquals(500, reserva.calcularPrecio());
		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 20), LocalDate.of(2030, 3, 25)));
	}

	@Test
	public void testReservarPropiedadNoDisponible() {
		Reserva reserva = this.huesped.reservar(this.propiedad, LocalDate.of(2030, 3, 12), LocalDate.of(2030, 3, 20));

		assertNull(reserva);
	}

	@Test
	public void testCancelarReservaFutura() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = this.huesped.reservar(this.propiedad, hoy.plusDays(10), hoy.plusDays(15));
		assertFalse(this.propiedad.consultarDisponibilidad(hoy.plusDays(10), hoy.plusDays(15)));

		this.huesped.cancelarReserva(reserva);

		assertTrue(this.propiedad.consultarDisponibilidad(hoy.plusDays(10), hoy.plusDays(15)));
	}

	@Test
	public void testCancelarReservaEnCursoNoSeCancela() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = this.huesped.reservar(this.propiedad, hoy.minusDays(1), hoy.plusDays(1));

		this.huesped.cancelarReserva(reserva);

		assertFalse(this.propiedad.consultarDisponibilidad(hoy.minusDays(1), hoy.plusDays(1)));
	}

	@Test
	public void testCancelarReservaQueNoExiste() {
		Reserva ajena = new Reserva(this.propiedad, new DateLapse(LocalDate.of(2030, 5, 1), LocalDate.of(2030, 5, 5)));

		this.huesped.cancelarReserva(ajena);

		assertFalse(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15)));
		assertTrue(this.propiedad.consultarDisponibilidad(LocalDate.of(2030, 5, 1), LocalDate.of(2030, 5, 5)));
	}

	@Test
	public void testIngresosSinPropiedades() {
		Usuario sinPropiedades = new Usuario("Carla", "Calle 3", 33333333);

		assertEquals(0, sinPropiedades.calcularIngresos(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31)));
	}

	@Test
	public void testIngresosDeUnaPropiedad() {
		assertEquals(375, this.propietario.calcularIngresos(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31)));
	}

	@Test
	public void testIngresosDeVariasPropiedades() {
		Propiedad otra = new Propiedad("Calle 4", "Depto", 200);
		this.propietario.agregarPropiedad(otra);
		this.huesped.reservar(otra, LocalDate.of(2030, 3, 12), LocalDate.of(2030, 3, 14));

		assertEquals(675, this.propietario.calcularIngresos(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31)));
	}

	@Test
	public void testIngresosSoloConLasReservasIncluidasEnElPeriodo() {
		Propiedad otra = new Propiedad("Calle 4", "Depto", 200);
		this.propietario.agregarPropiedad(otra);
		this.huesped.reservar(otra, LocalDate.of(2030, 3, 12), LocalDate.of(2030, 3, 14));

		assertEquals(300, this.propietario.calcularIngresos(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 14)));
	}

	@Test
	public void testIngresosLasReservasComoHuespedNoCuentan() {
		assertEquals(0, this.huesped.calcularIngresos(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31)));
	}
}