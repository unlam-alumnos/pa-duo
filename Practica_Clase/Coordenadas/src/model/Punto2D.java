package model;

public class Punto2D implements Punto {

	private double x;
	private double y;
	
	public Punto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double distanciaEntrePuntos(Punto punto) {
		Punto2D coordenada = (Punto2D) punto;
		double distanciaX = getX() - coordenada.getX();
		double distanciaY = getY() - coordenada.getY();
		double distancia = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
		return distancia;
	}
	
	@Override
	public double distanciaAlOrigen() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	@Override
	public Punto2D clone() {
		return new Punto2D(x, y);
	}
	
	@Override
	public Punto2D desplazamiento(Punto punto) {
		Punto2D nuevo = (Punto2D) punto;
		return new Punto2D(x + nuevo.getX(), y + nuevo.getY());
	}
	
	public void metodo2D() {
		System.out.println("metodo 2D");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
}
