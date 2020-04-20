/**
 * 
 */
package died.guia06;

import java.util.Comparator;

/**
 * @author yamil
 *
 */
public class CompardorAlumnoAlfabeticamente implements Comparator<Alumno> {
	
	@Override
	public int compare(Alumno a1,Alumno a2) {
		return a1.getNombre().compareTo(a2.getNombre());
	}

}
