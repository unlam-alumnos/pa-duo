package edu.unlam.circulos.model;

public class Coordenada {
	private double x;
	private double y;
	
	public Coordenada(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getDistanciaCon(Coordenada coordenada) {
		double distanciaX = getX() - coordenada.getX();
		double distanciaY = getY() - coordenada.getY();
		double distancia = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
		return distancia;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
