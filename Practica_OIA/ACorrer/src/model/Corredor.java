package model;

public class Corredor {
	private char genero;
	private int edad;
	private int categoria;
	
	public Corredor(char genero, int edad, int categoria) {
		this.genero = genero;
		this.edad = edad;
		this.categoria = categoria;
	}

	public char getGenero() {
		return genero;
	}

	public int getEdad() {
		return edad;
	}

	public int getCategoria() {
		return categoria;
	}
}
