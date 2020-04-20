package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno("Yamil", 1);
		Alumno a2 = new Alumno("Arturo", 2);
		
		Curso c1 = new Curso(1, "DIED", 2020, 5, 5, 0);
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		
		c1.imprimirInscriptosPorNombre();
		System.out.println();
		c1.imprimirInscriptosPorNroLibreta();
		System.out.println();
		c1.imprimirInscriptosPorCantCreditos();
		System.out.println();
		
		a1.aprobar(c1);
		System.out.println("Los creditos de "+a1.getNombre()+" son: "+a1.creditosObtenidos());
		System.out.println("Los creditos de "+a2.getNombre()+" son: "+a2.creditosObtenidos());
		
		
	}
}
