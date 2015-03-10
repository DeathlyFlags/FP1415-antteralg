package fp.grados.tipos;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public class NotaImpl implements Nota {
	private static final Integer CURSO_SIGUIENTE = 2000 - 1;
	private Asignatura asignatura;
	private Integer curso;
	private Double valor;
	private Convocatoria convocatoria;
	private Boolean mencionHonor;
	
	/**** Constructores ****/
	// region Constructores
	public NotaImpl(Asignatura asignatura, Integer curso,
			Convocatoria convocatoria, Double valor, Boolean mencionHonor) {
		checkNota(valor);
		checkCurso(curso);
		checkMatricula(valor, mencionHonor);

		this.asignatura = asignatura;
		this.curso = curso;
		this.valor = valor;
		this.convocatoria = convocatoria;
		this.mencionHonor = mencionHonor;
	}

	public NotaImpl(Asignatura asignatura, Integer curso,
			Convocatoria convocatoria, Double valor) {
		this(asignatura, curso, convocatoria, valor, false);
	}

	public NotaImpl(String nota) {
		// Fundamentos de
		// Programaci�n#1234567#12.0#ANUAL#1;2014;PRIMERA;10.0;true
		String[] s = nota.split(";");
		if (s.length != 5)
			throw new IllegalArgumentException(
					"NotaImpl.ConstructorCadena:: La cadena constructor ha de ser del tipo: Fundamentos de Programaci�n#1234567#12.0#ANUAL#1;2014;PRIMERA;10.0;true");
		for (int i = 0; i < s.length; i++)
			s[i] = s[i].trim();

		Integer curso = new Integer(s[1]);
		Double valor = new Double(s[3]);
		Boolean mHonor = new Boolean(s[4]);

		checkCurso(curso);
		checkNota(valor);
		checkMatricula(valor, mHonor);

		this.asignatura = new AsignaturaImpl(s[0]);
		this.curso = curso;
		this.convocatoria = Convocatoria.valueOf(s[2]);
		this.valor = valor;
		this.mencionHonor = mHonor;
	}

	// endregion

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public Integer getCursoAcademico() {
		return curso;
	}

	public Double getValor() {
		return valor;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public Boolean getMencionHonor() {
		return mencionHonor;
	}

	public Calificacion getCalificacion() {
		Calificacion calificacion = Calificacion.SUSPENSO;
		if (valor >= 5)
			calificacion = Calificacion.APROBADO;
		if (valor >= 7)
			calificacion = Calificacion.NOTABLE;
		if (valor >= 9)
			calificacion = Calificacion.SOBRESALIENTE;
		if (valor >= 9 && mencionHonor == true)
			calificacion = Calificacion.MATRICULA_DE_HONOR;
		return calificacion;
	}

	public String toString() {
		String cursoSiguiente = String.valueOf(getCursoAcademico()
				- CURSO_SIGUIENTE);
		if (cursoSiguiente.length() < 2)
			cursoSiguiente = "0" + cursoSiguiente;
		return getAsignatura() + ", " + getCursoAcademico() + "-"
				+ cursoSiguiente + ", " + getConvocatoria() + ", " + getValor()
				+ ", " + getCalificacion();
	}

	// Exceptions
	private void checkCurso(Integer curso) {
		if (curso < 1900 || curso > (LocalDate.now().getYear() + 1))
			throw new ExcepcionNotaNoValida(
					"NotaImpl.checkCurso:: El curso debe ser mayor a 1900 o menor a "
							+ String.valueOf(LocalDate.now().getYear() + 1));
	}

	private void checkNota(Double nota) {
		if (nota < 0 || nota > 10)
			throw new ExcepcionNotaNoValida(
					"NotaImpl.checkNota:: No puedes poner una nota negativa o mayor a 10");
	}

	private void checkMatricula(Double nota, Boolean matricula) {
		if (nota < 9 && matricula == true)
			throw new ExcepcionNotaNoValida(
					"NotaImpl.checkMatricula:: Para hacer una menci�n de honor la nota debe ser mayor o igual a 9");
	}

	public int compareTo(Nota n) {
		int c = getCursoAcademico().compareTo(n.getCursoAcademico());
		if (c == 0) {
			c = getAsignatura().compareTo(n.getAsignatura());
			if (c == 0)
				c = getConvocatoria().compareTo(n.getConvocatoria());
		}
		return c;
	}

	public boolean equals(Object o) {
		if (o instanceof Nota) {
			Nota n = (Nota) o;
			return getCursoAcademico().equals(n.getCursoAcademico())
					&& getAsignatura().equals(n.getAsignatura())
					&& getConvocatoria().equals(n.getConvocatoria());
		}
		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;

		return prime * result + getCursoAcademico().hashCode()
				+ getAsignatura().hashCode() + getConvocatoria().hashCode();
	}
}
