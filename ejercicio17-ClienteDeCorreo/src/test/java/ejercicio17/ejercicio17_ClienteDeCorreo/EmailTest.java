package ejercicio17.ejercicio17_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailTest {
	@Test
	public void contieneTextoSoloEnElTitulo() {
		Email email = new Email("Reunion lunes", "Traer informe");

		assertTrue(email.contiene("Reunion"));
	}

	@Test
	public void contieneTextoSoloEnElCuerpo() {
		Email email = new Email("Reunion lunes", "Traer informe");

		assertTrue(email.contiene("informe"));
	}

	@Test
	public void contieneTextoEnTituloYCuerpo() {
		Email email = new Email("Hola amigo", "Chau amigo");

		assertTrue(email.contiene("amigo"));
	}

	@Test
	public void noContieneTextoQueNoEstaEnNinguno() {
		Email email = new Email("Reunion lunes", "Traer informe");

		assertFalse(email.contiene("factura"));
	}

	@Test
	public void sacarAdjuntoQueEstaYEsElUnico() {
		Email email = new Email("Hola", "Chau");
		Archivo texto = new Archivo("a.txt");
		email.agregarAdjunto(texto);
		assertEquals(13, email.tamanio());

		email.sacarAdjunto(texto);

		assertEquals(8, email.tamanio());
	}

	@Test
	public void sacarAdjuntoQueEstaYNoEsElUnico() {
		Email email = new Email("Hola", "Chau");
		Archivo texto = new Archivo("a.txt");
		email.agregarAdjunto(texto);
		email.agregarAdjunto(new Archivo("foto.png"));
		assertEquals(21, email.tamanio());

		email.sacarAdjunto(texto);

		assertEquals(16, email.tamanio());
	}

	@Test
	public void sacarAdjuntoQueNoEsta() {
		Email email = new Email("Hola", "Chau");
		email.agregarAdjunto(new Archivo("a.txt"));

		email.sacarAdjunto(new Archivo("foto.png"));

		assertEquals(13, email.tamanio());
	}

	@Test
	public void tamanioTodoVacio() {
		assertEquals(0, new Email("", "").tamanio());
	}

	@Test
	public void tamanioSoloElTitulo() {
		assertEquals(4, new Email("Hola", "").tamanio());
	}

	@Test
	public void tamanioSoloElCuerpo() {
		assertEquals(9, new Email("", "Nos vemos").tamanio());
	}

	@Test
	public void tamanioSoloUnAdjunto() {
		Email email = new Email("", "");
		email.agregarAdjunto(new Archivo("a.txt"));

		assertEquals(5, email.tamanio());
	}

	@Test
	public void tamanioTituloCuerpoYUnAdjunto() {
		Email email = new Email("Hola", "Nos vemos");
		email.agregarAdjunto(new Archivo("a.txt"));

		assertEquals(18, email.tamanio());
	}

	@Test
	public void tamanioTituloCuerpoYDosAdjuntos() {
		Email email = new Email("Hola", "Nos vemos");
		email.agregarAdjunto(new Archivo("a.txt"));
		email.agregarAdjunto(new Archivo("foto.png"));

		assertEquals(26, email.tamanio());
	}
}