/**
 * 
 */
package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author yamil
 *
 */
class CursoTest {
	
	Alumno a1;
	Curso c1;

	@Test
	void testIncribirCorrecta() {
		a1 = new Alumno("a", 1);
		c1 = new Curso(1, "c1", 2020, 30, 5, 0);
		assertTrue(c1.inscribir(a1));
	}
	
	@Test
	void testNoIncribirCreditos() {
		a1 = new Alumno("a", 0);
		c1 = new Curso(1, "c1", 2020, 30, 5, 1);
		assertFalse(c1.inscribir(a1));
	}
	
	@Test
	void testNoIncribirCupo() {
		a1 = new Alumno("a", 1);
		c1 = new Curso(1, "c1", 2020, 0, 5, 0);
		assertFalse(c1.inscribir(a1));
	}
	
	@Test
	void testNoIncribirCicloLectibo() {
		a1 = new Alumno("a", 1);
		c1 = new Curso(1, "c1", 2020, 30, 5, 0);
		Curso c2 = new Curso(2, "c2", 2020, 30, 5, 0);
		Curso c3 = new Curso(3, "c3", 2020, 30, 5, 0);
		Curso c4 = new Curso(4, "c4", 2020, 30, 5, 0);
		c1.inscribir(a1);
		c2.inscribir(a1);
		c3.inscribir(a1);
		assertFalse(c4.inscribir(a1));
	}

}
