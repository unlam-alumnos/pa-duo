package model;

public class Combi extends Transporte{

	public Combi(double peso, double km) {
		super(peso, km, 15000,2000);
	}
	
	/* LA COMBI TIENE EL CHEQUEO "GENERICO" ASIQUE NO LO SOBREESCRIBO
	public boolean puedoAgregar(double pesoPaquete, double tamanioPaquete) {
		return peso + pesoPaquete <= PESO_MAX;
	}
	*/

}
