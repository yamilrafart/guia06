package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	
	/**
	 * CONSTRUCTOR
	 */
	public Alumno() {
		super();
	}
	
	

	/**
	 * CONSTRUCTOR
	 * @param nombre
	 * @param nroLibreta
	 * @param cursando
	 * @param aprobados
	 */
	public Alumno(String nombre, Integer nroLibreta, List<Curso> cursando, List<Curso> aprobados) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = cursando;
		this.aprobados = aprobados;
	}



	public int creditosObtenidos() {
		int creditos = 0;
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
		if (obj instanceof Alumno) {
			Alumno other = (Alumno) obj;
			if (this.nroLibreta == null) {
				if (other.nroLibreta != null) return false;
			} else if (!this.nroLibreta.equals(other.nroLibreta)) return false;
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Alumno unAlumno) {
		return this.nombre.compareTo(unAlumno.nombre);
	}
	
	

}
