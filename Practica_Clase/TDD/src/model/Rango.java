package model;

public class Rango {
	
	private int inicio;
	private int fin;
	
	public Rango(int i, int j) {
		this.inicio = i;
		this.fin = j;
	}

	public boolean contiene(int i) {
		return i >= inicio && i <= fin;
	}

}
