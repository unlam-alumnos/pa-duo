package model;

public class Punto3D extends Punto2D {

	private double z;
	
	public Punto3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	public double distanciaEntrePuntos(Punto3D coordenada) {
		double distanciaX = getX() - coordenada.getX();
		double distanciaY = getY() - coordenada.getY();
		double distanciaZ = z - coordenada.getZ();
		double distancia = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2) + Math.pow(distanciaZ, 2));
		return distancia;
	}
	
	public double distanciaAlOrigen() {
		return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(z, 2));
	}
	
	public Punto3D clone() {
		return new Punto3D(getX(), getY(), z);
	}
	
	public Punto2D desplazamiento(Punto3D nuevo) {
		return new Punto3D(getX() + nuevo.getX(), getY() + nuevo.getY(), z + nuevo.getZ());
	}
	
	public void metodo3D() {
		System.out.println("metodo 3D");
	}
	
	public double getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ", " + getZ() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto3D other = (Punto3D) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
}
