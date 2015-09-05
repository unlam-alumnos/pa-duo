package model;

public abstract class Transporte {

	private double PESO_MAX;
	private double KM_MAX;
	private double TP;

	private double peso;
	private double km;
	private char tipo;

	public Transporte(double peso, double km, char tipo) {
		super();
		this.peso = peso;
		this.km = km;
		this.tipo = tipo;

		switch (tipo) {
		case 'C':
			KM_MAX = 15000;
			PESO_MAX = 2000;
		case 'B':
			KM_MAX = 100;
			PESO_MAX = 35;
			TP = 10;
		case 'V':
			KM_MAX = 10;
			break;
		default:
			break;
		}
	}

	public boolean puedoAgregar(double pesoPaquete, double tamanioPaquete) {
		boolean condicionExtra = true;
		if (tipo == 'B' && tamanioPaquete > TP) {
			condicionExtra = false;
		} else if (tipo == 'V') {
			condicionExtra = pesoPaquete <= KM_MAX - km * 0.2;
		}
		return condicionExtra && peso + pesoPaquete <= PESO_MAX;
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
