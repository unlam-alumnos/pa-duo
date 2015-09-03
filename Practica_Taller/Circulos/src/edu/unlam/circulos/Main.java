package edu.unlam.circulos;

import edu.unlam.circulos.model.Circulo;
import edu.unlam.circulos.model.Coordenada;

public class Main {
	public static void main(String[] args) {
		Circulo c1 = new Circulo(1, new Coordenada(2, 2));
		System.out.println("Origen: " + c1.getOrigen());
		System.out.println("Radio: " + c1.getRadio());
		System.out.println("Diámetro: " + c1.getDiametro());
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perímetro: " + c1.getPerimetro());
		
		Coordenada dot = new Coordenada(4,3);
		System.out.println(c1.contieneCoordenada(dot));
		
	}
}
