package model;

public abstract class Transporte {

	protected double PESO_MAX;
	protected double KM_MAX;
	
	protected double peso;
	protected double km;

	public Transporte(double peso, double km, double km_max, double peso_max) {
		super();
		this.peso = peso;
		this.km = km;
		this.PESO_MAX = peso_max;
		this.KM_MAX = km_max;
	}
	
	// Dejo el desarrollo "GENERICO" del metodo 
	public boolean puedoAgregar(double pesoPaquete, double tamanioPaquete) {
		return peso + pesoPaquete <= PESO_MAX;
	}

	public boolean hayQueReparar() {
		return km >= KM_MAX;
	}

	public void reparar() {
		km = 0;
	}

	public void agregarPaquete(double pesoPaquete, double tamanioPaquete) {
		if (puedoAgregar(pesoPaquete, tamanioPaquete))
			peso += pesoPaquete;
	}

	public void recorrer(double kilometros) {
		if (!hayQueReparar()) {
			km += kilometros;
		}
	}
}
