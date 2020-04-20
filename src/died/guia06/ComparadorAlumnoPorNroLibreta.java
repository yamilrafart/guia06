/**
 * 
 */
package died.guia06;

import java.util.Comparator;

/**
 * @author yamil
 *
 */
public class ComparadorAlumnoPorNroLibreta implements Comparator<Alumno> {
	
	@Override
	public int compare(Alumno a1,Alumno a2) {
		return a1.getNroLibreta().compareTo(a2.getNroLibreta());
	}

}
