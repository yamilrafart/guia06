package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	private Registro log;
	
	
	
	/**
	 * CONSTRUCTOR POR DEFECTO
	 */
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	/**
	 * CONSTRUCTOR
	 * @param id
	 * @param nombre
	 * @param cicloLectivo
	 * @param cupo
	 * @param creditos
	 * @param creditosRequeridos
	 */
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo,Integer creditos, Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.inscriptos = new ArrayList<Alumno>();
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.log = new Registro();
	}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {		
		int contCursos = 0; 
		for(Curso unCurso : a.getCursando()) {         // Obtener la cantidad de materias del mismo ciclo lectivo del curso.
			if(unCurso.cicloLectivo.equals(this.cicloLectivo)) {
				contCursos++;
			}
		}
		if ((a.creditosObtenidos() >= this.creditosRequeridos)&&(this.inscriptos.size() < this.cupo)&&(contCursos < 3)) {
			try {
				log.registrar(this, "inscribir ",a.toString());
					this.inscriptos.add(a);
					a.inscripcionAceptada(this);
			} catch (IOException e) {
				System.out.println("Error al inscribir al alumno: " + e.getMessage());
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptosPorNombre() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(this.inscriptos, new CompardorAlumnoAlfabeticamente());
			System.out.println("Orden alfabetico:");
			for(Alumno a: this.inscriptos) {
				System.out.println("" + a.getNombre() + ", Nro de libreta: " + a.getNroLibreta());
			}
		} catch (IOException e) {
			System.out.println("Error al imprimir inscriptos: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * imprime los inscriptos en orden segun el numero de la libreta
	 */
	public void imprimirInscriptosPorNroLibreta() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(this.inscriptos,new ComparadorAlumnoPorNroLibreta());
			System.out.println("Orden segun el numero de la libreta:");
			for(Alumno a: this.inscriptos) {
				System.out.println("" + a.getNombre() + ", Nro de libreta: " + a.getNroLibreta());
			}
		} catch (IOException e) {
			System.out.println("Error al imprimir inscriptos: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * imprime los inscriptos en orden segun la cantidad de creditos
	 */
	public void imprimirInscriptosPorCantCreditos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(this.inscriptos, new ComparadorAlumnoPorCreditos());
			System.out.println("Orden segun la cantidad de creditos:");
			for(Alumno a: this.inscriptos) {
				System.out.println("" + a.getNombre() + ", Nro de libreta: " + a.getNroLibreta());
			}
		} catch (IOException e) {
			System.out.println("Error al imprimir inscriptos: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @return the creditos
	 */
	public Integer getCreditos() {
		return creditos;
	}

	/**
	 * @return the inscriptos
	 */
	public List<Alumno> getInscriptos() {
		return inscriptos;
	}
	
	public void inscribirAlumno(Alumno a) throws InscribirAlumnoException, RegistroAuditoriaException{
		
		int contCursos = 0; 
		for(Curso unCurso : a.getCursando()) {         // Obtener la cantidad de materias del mismo ciclo lectivo del curso.
			if(unCurso.cicloLectivo.equals(this.cicloLectivo)) {
				contCursos++;
			}
		}
		if (a.compareTo(a) < this.creditosRequeridos) {
			throw new InscribirAlumnoException("Creditos insuficientes");
		} else if (this.inscriptos.size() == this.cupo) {
			throw new InscribirAlumnoException("Cupo cubierto");
		} else if (contCursos == 3) {
			throw new InscribirAlumnoException("Ya inscripto a 3 cursos en este ciclo lectivo");
		}
		try {
			log.registrar(this, "inscribir ",a.toString());
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
		} catch (IOException e) {	
			e.printStackTrace();
			throw new RegistroAuditoriaException("Error al inscribir al alumno: " + e.getMessage());
		}
	}

}
