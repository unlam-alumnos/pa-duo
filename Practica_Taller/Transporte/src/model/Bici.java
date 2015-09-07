package model;

public class Bici extends Transporte{
	
	private double TP;
	
	public Bici(double peso, double km) {
		super(peso, km, 100, 35);
		this.TP = 10;
	}
	

	public boolean puedoAgregar(double pesoPaquete, double tamanioPaquete) {
		return tamanioPaquete <= TP && peso + pesoPaquete <= PESO_MAX;
	}

}
