package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;

// Este c�digo se les da como material adjunto al bolet�n T3
public class TestAsignatura {

	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testConstructorExcepcion3();
		testConstructorExcepcion4();
		testConstructorExcepcion5();
		testConstructorExcepcion6();
		testConstructorExcepcion7();

		testCompareTo1();
		testCompareTo2();
		testCompareTo3();

		testEquals1();
		testEquals2();
		testEquals3();
	}
	
	/******************************** CASOS DE PRUEBA **************************/

	private static void testConstructorNormal() {
		System.out
				.println("==================================Probando el constructor");
		testConstructor("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion1() {
		System.out
		.println("==================================Probando el constructor, c�digo de asignatura m�s largo");
		testConstructor("Fundamentos de Programaci�n","20500010",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion2() {
		System.out
		.println("==================================Probando el constructor, c�digo de asignatura m�s corto");
		testConstructor("Fundamentos de Programaci�n","205000",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion3() {
		System.out
				.println("==================================Probando el constructor, c�digo de asignatura no num�rico");
		testConstructor("Fundamentos de Programaci�n","2A50001",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion4() {
		System.out
				.println("==================================Probando el constructor, cr�ditos incorrectos (0.0)");
		testConstructor("Fundamentos de Programaci�n","2050001",0.0, TipoAsignatura.ANUAL, 1);
	}
		
	private static void testConstructorExcepcion5() {
		System.out
				.println("==================================Probando el constructor, cr�ditos incorrectos (-1.0)");
		testConstructor("Fundamentos de Programaci�n","2050001",-1.0, TipoAsignatura.ANUAL, 1);
	}
	
	
	private static void testConstructorExcepcion6() {
		System.out
				.println("==================================Probando el constructor, curso menor de 1");
		testConstructor("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, -2);
	}
	
	private static void testConstructorExcepcion7() {
		System.out
				.println("==================================Probando el constructor, curso mayor de 4");
		testConstructor("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 5);
	}
	
	/******************************** METODOS AUXILIARES **************************/
	
	private static void testConstructor(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, null);
			mostrarAsignatura(a);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepci�n ExcepcionAsignaturaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}


	private static void mostrarAsignatura(Asignatura a) {		
		System.out.println("Assignatura --> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tC�digo: <" + a.getCodigo() + ">");
		System.out.println("\tCr�ditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	}
	
	private static void testCompareTo1() {
		System.out.println("============== Asignatura 1 > Asignatura 2");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","3050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		compararElementos(Asignatura, Asignatura2);
	}

	private static void testCompareTo2() {
		System.out.println("============== Asignatura 2 > Asignatura 1");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = new AsignaturaImpl("Fundamentos de Programaci�n","4050001",12.0, TipoAsignatura.ANUAL, 1, null);
		compararElementos(Asignatura, Asignatura2);
	}

	private static void testCompareTo3() {
		System.out.println("============== Asignatura 1.compareTo(Asignatura 2) = 0");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		compararElementos(Asignatura, Asignatura2);
	}

	private static void testEquals1() {
		System.out
				.println("============== Asignatura 1.equals(Asignatura 2) && e1==e2");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = Asignatura;
		elementosIguales(Asignatura, Asignatura2);
	}

	private static void testEquals2() {
		System.out.println("============== Asignatura 1.equals(Asignatura 2)");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		elementosIguales(Asignatura, Asignatura2);
	}

	private static void testEquals3() {
		System.out.println("============== !Asignatura 1.equals(Asignatura 2)");
		Asignatura Asignatura = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1, null);
		Asignatura Asignatura2 = new AsignaturaImpl("Fundamentos de Programaci�n","3050001",12.0, TipoAsignatura.ANUAL, 1, null);
		elementosIguales(Asignatura, Asignatura2);
	}

	public static void compararElementos(Asignatura a, Asignatura b) {
		if (a.compareTo(b) > 0) {
			System.out.println("El elemento m�s grande es " + a);
		} else if (a.compareTo(b) < 0) {
			System.out.println("El elemento m�s grande es " + b);
		} else {
			System.out.println("Los elementos son iguales");
		}
	}

	public static void elementosIguales(Asignatura a, Asignatura b) {
		if (a.equals(b) && a == b) {
			System.out.println("Los elementos son iguales e id�nticos");
		} else if (a.equals(b)) {
			System.out.println("Los elementos son iguales pero no id�nticos");
		} else {
			System.out.println("Los elementos son distintos");
		}
	}

}
