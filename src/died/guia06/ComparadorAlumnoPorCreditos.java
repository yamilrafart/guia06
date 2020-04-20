/**
 * 
 */
package died.guia06;

import java.util.Comparator;

/**
 * @author yamil
 *
 */
public class ComparadorAlumnoPorCreditos implements Comparator<Alumno> {
	
	@Override
	public int compare(Alumno a1, Alumno a2) {
		return (a1.creditosObtenidos().compareTo(a2.creditosObtenidos()));
	}

}
 