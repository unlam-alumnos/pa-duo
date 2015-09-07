package model;

public class Anciana extends Transporte{
	
	public Anciana(double peso, double km) {
		super(peso, km, 10, 0);
	}
	

	public boolean puedoAgregar(double pesoPaquete, double tamanioPaquete) {
		return pesoPaquete <= KM_MAX - km * 0.2 && peso + pesoPaquete <= PESO_MAX;
	}
}
