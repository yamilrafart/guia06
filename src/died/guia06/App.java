package died.guia06;

public class App {

	public static void main(String[] args) {
		
		//INSCRIPCION CORRECTA
		Alumno a1 = new Alumno("Yamil", 1);
		Alumno a2 = new Alumno("Arturo", 2);
		
		Curso c1 = new Curso(1, "DIED", 2020, 2, 5, 0);
		
		try {
			c1.inscribirAlumno(a1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			c1.inscribirAlumno(a2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		c1.imprimirInscriptosPorNombre();
		System.out.println();
		c1.imprimirInscriptosPorNroLibreta();
		System.out.println();
		c1.imprimirInscriptosPorCantCreditos();
		System.out.println();
		
		a1.aprobar(c1);
		System.out.println("Los creditos de "+a1.getNombre()+" son: "+a1.creditosObtenidos());
		System.out.println("Los creditos de "+a2.getNombre()+" son: "+a2.creditosObtenidos());
		
		//CUPO CUBIERTO
//		Alumno a3 = new Alumno("Rafart", 3);
//		try {
//			c1.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		//CREDITOS INSUFICIENTES
//		Curso c2 = new Curso(2, "JAVA", 2020, 2, 5, 1);
//		try {
//			c2.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		//YA INSCRIPTO A 3 CURSOS EN ESTE CICLO LECTIVO
//		Curso c3 = new Curso(3, "C++", 2020, 2, 5, 0);
//		Curso c4 = new Curso(4, "PYTHON", 2020, 2, 5, 0);
//		Curso c5 = new Curso(5, "C", 2020, 2, 5, 0);
//		try {
//			c1.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}try {
//			c3.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		try {
//			c4.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		try {
//			c5.inscribirAlumno(a3);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
	}
}
