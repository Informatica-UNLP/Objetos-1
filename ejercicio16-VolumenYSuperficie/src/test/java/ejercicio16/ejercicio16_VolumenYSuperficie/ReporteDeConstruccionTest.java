package ejercicio16.ejercicio16_VolumenYSuperficie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	
	private ReporteDeConstruccion reporteDeConstruccion;
	
	@BeforeEach
	public void setUp(){
	this.reporteDeConstruccion = new ReporteDeConstruccion();
	
	}
	
	@Test
	public void testSacarPiezaExistente() {
		Pieza p1 = new PrismaRectangular(1, 2, 3, "Azul", "Hierro");
		Pieza p2 = new PrismaRectangular(2, 3, 4, "Azul", "Hierro");
		reporteDeConstruccion.agregarPieza(p1);
		reporteDeConstruccion.agregarPieza(p2);

		reporteDeConstruccion.sacarPieza(p1);

		assertEquals(24, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test
	public void testSacarPiezaInexistente() {
		Pieza p1 = new PrismaRectangular(1, 2, 3, "Azul", "Hierro");
		Pieza p2 = new PrismaRectangular(2, 3, 4, "Azul", "Hierro");
		Pieza p3 = new PrismaRectangular(4, 5, 6, "Azul", "Hierro");
		reporteDeConstruccion.agregarPieza(p1);
		reporteDeConstruccion.agregarPieza(p2);

		reporteDeConstruccion.sacarPieza(p3);

		assertEquals(30, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test 
	public void testReporteDeConstruccionPiezasVacia(){
		assertEquals(0, this.reporteDeConstruccion.volumenDeMaterial("Hierro"));
		assertEquals(0, this.reporteDeConstruccion.superficieDeColor("Azul"));
	}
	
	@Test
	public void testUnaPiezaMaterialNoCoincide() {
		reporteDeConstruccion.agregarPieza(new Cilindro(2, 3, "Azul", "Hierro"));
		assertEquals(0, reporteDeConstruccion.volumenDeMaterial("Madera"));
	}

	@Test
	public void testUnaPiezaMaterialCoincide() {
		reporteDeConstruccion.agregarPieza(new Cilindro(2, 3, "Azul","Hierro"));
		assertEquals(12 * Math.PI, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test
	public void testUnaPiezaColorNoCoincide() {
		reporteDeConstruccion.agregarPieza(new Cilindro(2, 3,"Azul", "Hierro"));
		assertEquals(0, reporteDeConstruccion.superficieDeColor("Rojo"));
	}
	
	@Test
	public void testUnaPiezaColorCoincide() {
		reporteDeConstruccion.agregarPieza(new Cilindro(2, 3,"Azul", "Hierro"));
		assertEquals(20 * Math.PI, reporteDeConstruccion.superficieDeColor("Azul"));
	}
	
	@Test
	public void testVariasPiezasMismoMaterial() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Azul", "Hierro"));
		assertEquals(30, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}

	@Test
	public void testFiltraPiezasDeOtroMaterial() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 1, 1, "Naranja", "Cobre"));
		assertEquals(30, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test
	public void testVariasPiezasMaterialInexistente() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Rojo", "Madera"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Amarillo", "Estanio"));
		assertEquals(0, reporteDeConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test
	public void testVariasPiezasMismoColor() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Azul", "Hierro"));
		assertEquals(74, reporteDeConstruccion.superficieDeColor("Azul"));
	}

	@Test
	public void testFiltraPiezasDeOtroColor() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Azul", "Hierro"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 1, 1, "Naranja", "Cobre"));
		assertEquals(74, reporteDeConstruccion.superficieDeColor("Azul"));
	}
	

	@Test
	public void testVariasPiezasColorInexistente() {
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(1, 2, 3, "Rojo", "Madera"));
		reporteDeConstruccion.agregarPieza(new PrismaRectangular(2, 3, 4, "Amarillo", "Estanio"));
		assertEquals(0, reporteDeConstruccion.superficieDeColor("Azul"));
	}
}