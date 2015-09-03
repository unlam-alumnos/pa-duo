package edu.unlam.circulos.model;

public class Rectangulo {
	private double alto;
	private double ancho;
	private Coordenada origen;

	public Rectangulo(Coordenada c1, Coordenada c2) {
		this.alto = Math.abs(c1.getY() - c2.getY());
		this.ancho = Math.abs(c1.getX() - c2.getX());
		double minX = c1.getX() < c2.getX() ? c1.getX() : c2.getX();
		double minY = c1.getY() < c2.getY() ? c1.getY() : c2.getY();
		this.origen = new Coordenada(minX, minY);
	}

	public boolean contieneCoordenada(Coordenada coordenada) {
		return (coordenada.getX() >= origen.getX() && coordenada.getX() <= origen.getX() + ancho) 
				&& (coordenada.getY() >= origen.getY() && coordenada.getY() <= origen.getY() + alto);
	}
	
	public boolean hayInterseccion(Circulo circulo) {
		Coordenada vii = origen;
		Coordenada vid = new Coordenada(origen.getX() + ancho, origen.getY());
		Coordenada vsi = new Coordenada(origen.getX(), origen.getY() + alto);
		Coordenada vsd = new Coordenada(origen.getX() + ancho, origen.getY() + alto);
		
		double dii = vii.getDistanciaCon(origen);
		double did = vid.getDistanciaCon(origen);
		double dsi = vsi.getDistanciaCon(origen);
		double dsd = vsd.getDistanciaCon(origen);
		
		return dii <= dii - circulo.getRadio()
			|| did <= did - circulo.getRadio()
			|| dsi <= dsi - circulo.getRadio()
			|| dsd <= dsd - circulo.getRadio();
	}
	
	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}

	public Coordenada getOrigen() {
		return origen;
	}
}
