package fp.grados.tipos;

import java.util.Optional;

import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl2 extends CentroImpl {
	
	/** Bolet�n 12 **/
	public CentroImpl2(String nombre, String direccion, Integer numPlantas,
			Integer numSotanos) {
		super(nombre, direccion, numPlantas, numSotanos);
	}
	
	public Espacio getEspacioMayorCapacidad() {
		Optional<Espacio> ret = this.getEspaciosOrdenadosPorCapacidad().stream().findFirst();
		if(!ret.isPresent())
			throw new ExcepcionCentroOperacionNoPermitida(
					"CentroImpl.getEspacioMayorCapacidad:: El centro no tiene ning�n espacio.");
		return ret.get();
	}
	
	/* Opci�n de clase:
	 * 
	 public Espacio getEspacioMayorCapacidad() {
		Optional<Espacio> ret = getEspacios().stream.max(Comparator.comparing(Espacio::getCapacidad));
		if (!ret.isPresent())
			throw new ExcepcionCentroOperacionNoPermitida(
				"CentroImpl.getEspacioMayorCapacidad:: El centro no tiene ning�n espacio.");
		
		return ret.get();
	 }
	 * 
	 */

}
