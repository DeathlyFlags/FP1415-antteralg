package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoBeca;

//Este c�digo se les da como material adjunto al bolet�n T3
public class TestBeca {

	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		testConstructor1Excepcion4();
		testConstructor1Excepcion5();
		testConstructor1Excepcion6();

		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
		testConstructor2Excepcion4();

		testSetCuantiaTotalNormal();
		testSetCuantiaTotalExcepcion1();

		testSetDuracionNormal();
		testSetDuracionExcepcion1();

		testCompareTo1();
		testCompareTo2();
		testCompareTo3();

		testEquals1();
		testEquals2();
		testEquals3();
	}

	/******************************** CASOS DE PRUEBA **************************/

	private static void testConstructor1Normal() {
		System.out
				.println("==================================Probando el primer constructor");
		testConstructor1("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion1() {
		System.out
				.println("==================================Probando el primer constructor, pocos caracteres en el c�digo");
		testConstructor1("ABC12", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion2() {
		System.out
				.println("==================================Probando el primer constructor, demasiados caracteres en el c�digo");
		testConstructor1("ABC12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion3() {
		System.out
				.println("==================================Probando el primer constructor, pocas letras en el c�digo");
		testConstructor1("AB12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion4() {
		System.out
				.println("==================================Probando el primer constructor, pocos d�gitos en el c�digo");
		testConstructor1("ABCD123", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion5() {
		System.out
				.println("==================================Probando el primer constructor, cuant�a total menor a la m�nima");
		testConstructor1("ABC1234", 0.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion6() {
		System.out
				.println("==================================Probando el primer constructor, duraci�n menor a 1");
		testConstructor1("ABC1234", 10000.0, -1, TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Normal() {
		System.out
				.println("==================================Probando el segundo constructor");
		testConstructor2("ABC1234", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion1() {
		System.out
				.println("==================================Probando el segundo constructor, pocos caracteres en el c�digo");
		testConstructor2("ABC12", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion2() {
		System.out
				.println("==================================Probando el segundo constructor, demasiados caracteres en el c�digo");
		testConstructor2("ABC12345", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion3() {
		System.out
				.println("==================================Probando el segundo constructor, pocas letras en el c�digo");
		testConstructor2("AB12345", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion4() {
		System.out
				.println("==================================Probando el segundo constructor, pocos d�gitos en el c�digo");
		testConstructor2("ABCD123", TipoBeca.ORDINARIA);
	}

	private static void testSetCuantiaTotalNormal() {
		System.out
				.println("==================================Probando setCuantiaTotal");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 12000.0);
	}

	private static void testSetCuantiaTotalExcepcion1() {
		System.out
				.println("==================================Probando setCuantiaTotal con cuant�a total menor a la m�nima");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 120.0);
	}

	private static void testSetDuracionNormal() {
		System.out
				.println("==================================Probando setDuracion");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 12);
	}

	private static void testSetDuracionExcepcion1() {
		System.out
				.println("==================================Probando setDuracion con duraci�n menor a 1");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 0);
	}

	/******************************** METODOS AUXILIARES **************************/

	private static void testConstructor1(String codigo, Double cuantiaTotal,
			Integer duracion, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testSetCuantiaTotal(Beca b, Double cuantiaTotal) {
		try {
			System.out.println("La cuant�a total antes de la operaci�n es: "
					+ b.getCuantiaTotal());
			System.out.println("El nuevo valor es: " + cuantiaTotal);
			b.setCuantiaTotal(cuantiaTotal);
			System.out.println("La cuant�a total despu�s de la operaci�n es: "
					+ b.getCuantiaTotal());
		} catch (ExcepcionBecaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testSetDuracion(Beca b, Integer duracion) {
		try {
			System.out.println("La duraci�n antes de la operaci�n es: "
					+ b.getDuracion());
			System.out.println("El nuevo valor es: " + duracion);
			b.setDuracion(duracion);
			System.out.println("La duraci�n despu�s de la operaci�n es: "
					+ b.getDuracion());
		} catch (ExcepcionBecaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void mostrarBeca(Beca b) {
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tC�digo: <" + b.getCodigo() + ">");
		System.out.println("\tCuant�a total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuraci�n: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out
				.println("\tCuant�a mensual: <" + b.getCuantiaMensual() + ">");
	}

	private static void testCompareTo1() {
		System.out.println("============== Beca 1 > Beca 2");
		Beca Beca = new BecaImpl("ZAC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		compararElementos(Beca, Beca2);
	}

	private static void testCompareTo2() {
		System.out.println("============== Beca 2 > Beca 1");
		Beca Beca = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = new BecaImpl("ZBC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		compararElementos(Beca, Beca2);
	}

	private static void testCompareTo3() {
		System.out.println("============== Beca 1.compareTo(Beca 2) = 0");
		Beca Beca = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		compararElementos(Beca, Beca2);
	}

	private static void testEquals1() {
		System.out.println("============== Beca 1.equals(Beca 2) && e1==e2");
		Beca Beca = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = Beca;
		elementosIguales(Beca, Beca2);
	}

	private static void testEquals2() {
		System.out.println("============== Beca 1.equals(Beca 2)");
		Beca Beca = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		elementosIguales(Beca, Beca2);
	}

	private static void testEquals3() {
		System.out.println("============== !Beca 1.equals(Beca 2)");
		Beca Beca = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca Beca2 = new BecaImpl("ZBC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		elementosIguales(Beca, Beca2);
	}

	public static void compararElementos(Beca a, Beca b) {
		if (a.compareTo(b) > 0) {
			System.out.println("El elemento m�s grande es " + a);
		} else if (a.compareTo(b) < 0) {
			System.out.println("El elemento m�s grande es " + b);
		} else {
			System.out.println("Los elementos son iguales");
		}
	}

	public static void elementosIguales(Beca a, Beca b) {
		if (a.equals(b) && a == b) {
			System.out.println("Los elementos son iguales e id�nticos");
		} else if (a.equals(b)) {
			System.out.println("Los elementos son iguales pero no id�nticos");
		} else {
			System.out.println("Los elementos son distintos");
		}
	}

}
