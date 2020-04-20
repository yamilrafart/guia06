package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	
	/**
	 * CONSTRUCTOR POR DEFECTO
	 */
	public Alumno() {
		super();
	}

	/**
	 * CONSTRUCTOR
	 * @param nombre
	 * @param nroLibreta
	 */
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Integer creditosObtenidos() {
		Integer creditos = 0;
		for (Curso unCurso : this.aprobados) {
			creditos += unCurso.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		return ((obj instanceof Alumno)&&(this.nroLibreta.equals(((Alumno)obj).nroLibreta)));
	}
	
	@Override
	public int compareTo(Alumno unAlumno) {
		return this.nombre.compareTo(unAlumno.nombre);
	}

	/**
	 * @return the aprobados
	 */
	public List<Curso> getAprobados() {
		return aprobados;
	}

	/**
	 * @return the cursando
	 */
	public List<Curso> getCursando() {
		return cursando;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the nroLibreta
	 */
	public Integer getNroLibreta() {
		return nroLibreta;
	}	
	
	

}
