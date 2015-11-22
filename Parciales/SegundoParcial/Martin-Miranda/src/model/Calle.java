<<<<<<< HEAD
package model;

public class Calle {
	private int id;
	private int origen;
	private int destino;
	private int costo;

	public Calle(int id, int origen, int destino, int costo) {
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public String toString() {
		return "Calle [" + id + ", " + origen + ", " + destino + ", " + costo + "]";
	}
}
=======
package model;

public class Calle {
	private int id;
	private int origen;
	private int destino;
	private int costo;

	public Calle(int id, int origen, int destino, int costo) {
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public String toString() {
		return "Calle [" + id + ", " + origen + ", " + destino + ", " + costo + "]";
	}
}
>>>>>>> c71b9c6f0184c40c0ed80a1813f7278fee57968b
