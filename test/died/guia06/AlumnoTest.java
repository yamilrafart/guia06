package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	
	Alumno a1 = new Alumno("Yamil", 1);
	Curso c1 = new Curso(1,"DIED",2020,30,5,5);

	@BeforeEach
	public void init() {
		
	}
	
	@Test
	void testCreditosObtenidos() {
		int credito = a1.creditosObtenidos();
		assertEquals(0,credito);
	}

	@Test
	void testAprobar() {
		a1.inscripcionAceptada(c1);
		a1.aprobar(c1);
		assertTrue(a1.getAprobados().contains(c1) && !a1.getCursando().contains(c1));
	}

	@Test
	void testInscripcionAceptada() {
		a1.inscripcionAceptada(c1);
		assertTrue(a1.getCursando().contains(c1));
	}

}
