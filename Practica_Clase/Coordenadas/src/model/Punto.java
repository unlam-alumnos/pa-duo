package model;

public interface Punto {
	Punto clone();
	
	double distanciaEntrePuntos(Punto punto);
	
	double distanciaAlOrigen();
	
	Punto desplazamiento(Punto punto);
	
	String toString();

	boolean equals(Object punto);
}
