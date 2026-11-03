package ejercicio18.ejercicio18_IntervaloDeTiempo;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DateLapseTest {
	
	DateLapse dateLapse0,dateLapse1, dateLapse2 ;
	
	@BeforeEach
	void setUp() throws Exception {
		this.dateLapse0 = new DateLapse(LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 10));
	    this.dateLapse1 = new DateLapse(LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 11));
	    this.dateLapse2 = new DateLapse(LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 15));
	    
	}
	
    @Test
    public void testNoTranscurrenDias() {
        assertEquals(0, this.dateLapse0.sizeInDays());
    }
    
    @Test
    public void testTranscurreUnDia() {
        assertEquals(1, this.dateLapse1.sizeInDays());
    }
    
    @Test
    public void testTranscurrenVariosDias() {
        assertEquals(5, this.dateLapse2.sizeInDays());
    }
    
    @Test
    public void testFechaIgualAFrom() {
        assertTrue(this.dateLapse2.includesDate(LocalDate.of(2024, 3, 10)));
    }
    
    @Test
    public void testFechaIgualATo() {
        assertTrue(this.dateLapse2.includesDate(LocalDate.of(2024, 3, 15)));
    }
    
    @Test
    public void testFechaAnteriorAFrom() {
        assertFalse(this.dateLapse2.includesDate(LocalDate.of(2024, 3, 9)));
    }
   
    @Test
    public void testFechaPosteriorATo() {
        assertFalse(this.dateLapse2.includesDate(LocalDate.of(2024, 3, 16)));
    }
    
    @Test
    public void testFechaIncluida() {
        assertTrue(this.dateLapse2.includesDate(LocalDate.of(2024, 3, 12)));
    }
}
