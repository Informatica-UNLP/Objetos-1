package ejercicio16.ejercicio16_VolumenYSuperficie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	
	@Test
	public void volumenLadoMayorCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 0, 3,"Azul","Hierro");
		assertEquals(0, prismaRectangular.volumen());
	}
	
	@Test
	public void volumenLadoMayorPositivo() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 3, "Azul", "Hierro");
		assertEquals(18, prismaRectangular.volumen());
	}
	
	@Test
	public void superficieLadoMayorCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 0, 3,"Azul","Hierro");
		assertEquals(12, prismaRectangular.superficie());
	}
	
	@Test
	public void superficieLadoMayorPositivo() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 3, "Azul", "Hierro");
		assertEquals(42, prismaRectangular.superficie());	
	}
	
	@Test
	public void volumenLadoMenorCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(0, 2, 3,"Azul","Hierro");
		assertEquals(0, prismaRectangular.volumen());
	}
	
	@Test
	public void volumenLadoMenorPositivo() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(3, 2, 3, "Azul", "Hierro");
		assertEquals(18, prismaRectangular.volumen());
	}
	
	@Test
	public void superficieLadoMenorCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(0, 2, 3,"Azul","Hierro");
		assertEquals(12, prismaRectangular.superficie());
	}
	
	@Test
	public void superficieLadoMenorPositivo() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(3, 2, 3, "Azul", "Hierro");
		assertEquals(42, prismaRectangular.superficie());	
	}
	
	@Test
	public void volumenAlturaCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 0,"Azul","Hierro");
		assertEquals(0, prismaRectangular.volumen());
	}
	
	@Test
	public void volumenAlturaPositiva() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 3, "Azul", "Hierro");
		assertEquals(18, prismaRectangular.volumen());
	}
	
	@Test
	public void superficieAlturaCero() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 0,"Azul","Hierro");
		assertEquals(12, prismaRectangular.superficie());
	}
	
	@Test
	public void superficieAlturaPositiva() {
		PrismaRectangular prismaRectangular = new PrismaRectangular(2, 3, 3, "Azul", "Hierro");
		assertEquals(42, prismaRectangular.superficie());	
	}	
}