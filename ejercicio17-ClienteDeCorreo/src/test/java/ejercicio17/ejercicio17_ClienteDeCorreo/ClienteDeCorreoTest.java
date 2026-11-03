package ejercicio17.ejercicio17_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

	private ClienteDeCorreo cliente;
	private Carpeta trabajo;

	@BeforeEach
	public void setUp() {
		cliente = new ClienteDeCorreo();
		trabajo = new Carpeta("Trabajo");
	}

	// ---------- sacarCarpeta ----------

	@Test
	public void sacarCarpetaAgregada() {
		trabajo.agregarEmail(new Email("Hola", "Chau"));
		cliente.agregarCarpeta(trabajo);
		assertEquals(8, cliente.espacioOcupado()); 

		cliente.sacarCarpeta(trabajo);

		assertEquals(0, cliente.espacioOcupado());
	}

	@Test
	public void sacarCarpetaQueNuncaSeAgrego() {
		cliente.recibir(new Email("Hola", "Chau")); 

		cliente.sacarCarpeta(trabajo);

		assertEquals(8, cliente.espacioOcupado());
	}

	@Test
	public void sacarElInboxNoLoSaca() {
		cliente.sacarCarpeta(cliente.getInbox());

		cliente.recibir(new Email("Hola", "Chau")); 

		assertEquals(8, cliente.espacioOcupado());
	}

	// ---------- buscar ----------

	@Test
	public void buscarTextoSoloEnElInbox() {
		Email enInbox = new Email("Reunion lunes", "Traer informe");
		cliente.recibir(enInbox);

		assertSame(enInbox, cliente.buscar("lunes"));
	}

	@Test
	public void buscarTextoSoloEnOtraCarpeta() {
		Email enTrabajo = new Email("Reunion martes", "Traer factura");
		cliente.recibir(new Email("Hola", "Chau")); 
		trabajo.agregarEmail(enTrabajo);
		cliente.agregarCarpeta(trabajo);

		assertSame(enTrabajo, cliente.buscar("martes"));
	}

	@Test
	public void buscarTextoEnDosLugaresDevuelveElDelInbox() {
		Email enInbox = new Email("Reunion lunes", "Traer informe");
		Email enTrabajo = new Email("Reunion martes", "Traer factura");
		cliente.recibir(enInbox);
		trabajo.agregarEmail(enTrabajo);
		cliente.agregarCarpeta(trabajo);

		assertSame(enInbox, cliente.buscar("Reunion"));
	}

	@Test
	public void buscarTextoQueNoEstaEnNinguno() {
		cliente.recibir(new Email("Reunion lunes", "Traer informe"));
		trabajo.agregarEmail(new Email("Reunion martes", "Traer factura"));
		cliente.agregarCarpeta(trabajo);

		assertNull(cliente.buscar("vacaciones"));
	}

	// ---------- espacioOcupado ----------

	@Test
	public void espacioOcupadoSoloInboxVacio() {
		assertEquals(0, cliente.espacioOcupado());
	}

	@Test
	public void espacioOcupadoSoloInboxConUnEmail() {
		cliente.recibir(new Email("Hola", "Chau")); 

		assertEquals(8, cliente.espacioOcupado());
	}

	@Test
	public void espacioOcupadoInboxYOtraCarpeta() {
		cliente.recibir(new Email("Hola", "Chau")); 

		Email conAdjunto = new Email("Hola", "Chau"); 
		conAdjunto.agregarAdjunto(new Archivo("a.txt"));
		trabajo.agregarEmail(conAdjunto);
		cliente.agregarCarpeta(trabajo);

		assertEquals(21, cliente.espacioOcupado()); 
	}
}