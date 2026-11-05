package ejercicio22.ejercicio22.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ejercicio18.ejercicio18_IntervaloDeTiempo.DateLapse;

public class ReservaTest {

	private Propiedad propiedad;

	@BeforeEach
	void setUp() throws Exception {
		this.propiedad = new Propiedad("Calle 1", "Casa", 100);
	}

	@Test
	public void testPrecioDeVariasNoches() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15)));

		assertEquals(500, reserva.calcularPrecio());
	}

	@Test
	public void testPrecioDeUnaNoche() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 11)));

		assertEquals(100, reserva.calcularPrecio());
	}

	@Test
	public void testPrecioDeCeroNoches() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 10)));

		assertEquals(0, reserva.calcularPrecio());
	}

	@Test
	public void testIncluidaEnUnPeriodoMasGrande() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 10), LocalDate.of(2030, 3, 15)));
		DateLapse marzo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31));

		assertTrue(reserva.estaIncluidaEn(marzo));
	}

	@Test
	public void testIncluidaEnUnPeriodoIgual() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31)));
		DateLapse marzo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31));

		assertTrue(reserva.estaIncluidaEn(marzo));
	}

	@Test
	public void testNoIncluidaPorqueTerminaDespues() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 3, 28), LocalDate.of(2030, 4, 3)));
		DateLapse marzo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31));

		assertFalse(reserva.estaIncluidaEn(marzo));
	}

	@Test
	public void testNoIncluidaPorqueEmpiezaAntes() {
		Reserva reserva = new Reserva(this.propiedad,
				new DateLapse(LocalDate.of(2030, 2, 25), LocalDate.of(2030, 3, 5)));
		DateLapse marzo = new DateLapse(LocalDate.of(2030, 3, 1), LocalDate.of(2030, 3, 31));

		assertFalse(reserva.estaIncluidaEn(marzo));
	}

	@Test
	public void testEnCursoEnElMedio() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.minusDays(2), hoy.plusDays(2)));

		assertTrue(reserva.estaEnCurso());
	}

	@Test
	public void testEnCursoEmpiezaHoy() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy, hoy.plusDays(3)));

		assertTrue(reserva.estaEnCurso());
	}

	@Test
	public void testEnCursoTerminaHoy() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.minusDays(3), hoy));

		assertTrue(reserva.estaEnCurso());
	}

	@Test
	public void testNoEnCursoEmpiezaManiana() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.plusDays(1), hoy.plusDays(4)));

		assertFalse(reserva.estaEnCurso());
	}

	@Test
	public void testNoEnCursoTerminoAyer() {
		LocalDate hoy = LocalDate.now();
		Reserva reserva = new Reserva(this.propiedad, new DateLapse(hoy.minusDays(4), hoy.minusDays(1)));

		assertFalse(reserva.estaEnCurso());
	}
}