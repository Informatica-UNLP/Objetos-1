package ejercicio21.ejercicio21_EvenNumberSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvenNumberSetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() throws Exception {
		this.numbers = new EvenNumberSet();
	}

	@Test
	public void testAgregarPar() {
		assertTrue(this.numbers.add(2));
		assertEquals(1, this.numbers.size());
		assertTrue(this.numbers.contains(2));
	}

	@Test
	public void testAgregarImparNoSeAgrega() {
		assertFalse(this.numbers.add(1));
		assertTrue(this.numbers.isEmpty());
	}

	@Test
	public void testAgregarParRepetido() {
		this.numbers.add(2);

		assertFalse(this.numbers.add(2));
		assertEquals(1, this.numbers.size());
	}

	@Test
	public void testAgregarCero() {
		assertTrue(this.numbers.add(0));
		assertTrue(this.numbers.contains(0));
	}

	@Test
	public void testAgregarParNegativo() {
		assertTrue(this.numbers.add(-2));
		assertTrue(this.numbers.contains(-2));
	}

	@Test
	public void testAgregarImparNegativoNoSeAgrega() {
		assertFalse(this.numbers.add(-3));
		assertTrue(this.numbers.isEmpty());
	}

	@Test
	public void testAddAllSoloAgregaLosPares() {
		this.numbers.addAll(List.of(1, 2, 3, 4));

		assertEquals(2, this.numbers.size());
		assertTrue(this.numbers.contains(2));
		assertTrue(this.numbers.contains(4));
	}
}