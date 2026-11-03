package ejercicio17.ejercicio17_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	private Carpeta carpeta;
	private Carpeta destino;

	@BeforeEach
	public void setUp() {
		carpeta = new Carpeta("Origen");
		destino = new Carpeta("Destino");
	}

	@Test
	public void sacarEmailQueEstaYEsElUnico() {
		Email unico = new Email("Hola", "Chau");
		carpeta.agregarEmail(unico);
		assertEquals(8, carpeta.espacioOcupado());

		carpeta.sacarEmail(unico);

		assertEquals(0, carpeta.espacioOcupado());
	}

	@Test
	public void sacarEmailQueEstaYNoEsElUnico() {
		Email de8 = new Email("Hola", "Chau");
		Email de13 = new Email("Hola", "Chau");
		de13.agregarAdjunto(new Archivo("a.txt"));
		carpeta.agregarEmail(de8);
		carpeta.agregarEmail(de13);
		assertEquals(21, carpeta.espacioOcupado());

		carpeta.sacarEmail(de8);

		assertEquals(13, carpeta.espacioOcupado());
	}

	@Test
	public void sacarEmailQueNoEsta() {
		carpeta.agregarEmail(new Email("Hola", "Chau"));
		Email otro = new Email("Gracias", "Saludos");

		carpeta.sacarEmail(otro);

		assertEquals(8, carpeta.espacioOcupado());
	}

	@Test
	public void moverEmailQueNoEsElUnicoDelOrigen() {
		Email aMover = new Email("Hola", "Chau");
		Email de13 = new Email("Hola", "Chau");
		de13.agregarAdjunto(new Archivo("a.txt"));
		Email de16 = new Email("Hola", "Chau");
		de16.agregarAdjunto(new Archivo("foto.png"));
		carpeta.agregarEmail(aMover);
		carpeta.agregarEmail(de13);
		destino.agregarEmail(de16);

		carpeta.mover(aMover, destino);

		assertEquals(13, carpeta.espacioOcupado());
		assertEquals(24, destino.espacioOcupado());
	}

	@Test
	public void moverEmailQueEsElUnicoDelOrigen() {
		Email aMover = new Email("Hola", "Chau");
		Email de16 = new Email("Hola", "Chau");
		de16.agregarAdjunto(new Archivo("foto.png"));
		carpeta.agregarEmail(aMover);
		destino.agregarEmail(de16);

		carpeta.mover(aMover, destino);

		assertEquals(0, carpeta.espacioOcupado());
		assertEquals(24, destino.espacioOcupado());
	}

	@Test
	public void espacioOcupadoCarpetaVacia() {
		assertEquals(0, carpeta.espacioOcupado());
	}

	@Test
	public void espacioOcupadoConUnEmail() {
		carpeta.agregarEmail(new Email("Hola", "Chau"));

		assertEquals(8, carpeta.espacioOcupado());
	}

	@Test
	public void espacioOcupadoConVariosEmails() {
		Email de13 = new Email("Hola", "Chau");
		de13.agregarAdjunto(new Archivo("a.txt"));
		carpeta.agregarEmail(new Email("Hola", "Chau"));
		carpeta.agregarEmail(de13);

		assertEquals(21, carpeta.espacioOcupado());
	}

	@Test
	public void buscarEnCarpetaVacia() {
		assertNull(carpeta.buscar("lunes"));
	}

	@Test
	public void buscarNingunEmailTieneElTexto() {
		carpeta.agregarEmail(new Email("Hola", "Chau"));
		carpeta.agregarEmail(new Email("Gracias", "Saludos"));

		assertNull(carpeta.buscar("lunes"));
	}

	@Test
	public void buscarUnSoloEmailTieneElTexto() {
		Email buscado = new Email("Reunion lunes", "Traer informe");
		carpeta.agregarEmail(new Email("Hola", "Chau"));
		carpeta.agregarEmail(new Email("Gracias", "Saludos"));
		carpeta.agregarEmail(buscado);

		assertSame(buscado, carpeta.buscar("lunes"));
	}

	@Test
	public void buscarVariosEmailsTienenElTextoDevuelveElPrimero() {
		Email primero = new Email("Reunion lunes", "Traer informe");
		Email segundo = new Email("Reunion martes", "Traer factura");
		carpeta.agregarEmail(primero);
		carpeta.agregarEmail(segundo);

		assertSame(primero, carpeta.buscar("Reunion"));
	}
}