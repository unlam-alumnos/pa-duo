package edu.unlam.circulos.model;

public class Circulo {
	private double radio;
	private Coordenada origen;

	public Circulo(double radio, double origenX, double origenY) {
		this(radio, new Coordenada(origenX, origenY));
	}
	
	public Circulo(double radio, Coordenada origen) {
		this.radio = radio;
		this.origen = origen;
	}
	
	public double getDiametro() {
		return 2 * radio;
	}

	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}

	public double getRadio() {
		return radio;
	}

	public Coordenada getOrigen() {
		return origen;
	}
	
	public boolean contieneCoordenada(Coordenada coordenada) {
		return coordenada.getDistanciaCon(origen) <= radio;
	}
	
	public boolean intersectaCirculo(Circulo circulo) {
		return origen.getDistanciaCon(circulo.getOrigen()) <= radio + circulo.getRadio();
	}
}
