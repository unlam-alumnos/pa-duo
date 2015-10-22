package test;

import java.util.Random;

/**
 * Clase generadora del lote de prueba de fatiga.
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public class Generador {

	private final static int[] CANTIDADES = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	private final static String[] SUSTANTIVOS = { "pelotas", "carteras",
			"computadoras", "remeras", "polleras", "radios", "manzanas",
			"sandías", "mochilas" };
	
	private final static String[] ADJETIVOS = { "grandes", "chicas", "rojas",
			"lindas", "feas", "verdes", "duras", "blandas", "maduras" };

	public static void main(String[] args) {
		String texto = "";
		while (texto.length() < 990950) {
			int rand = new Random().nextInt(8) + 1;
			texto += CANTIDADES[rand];
			texto += " " + SUSTANTIVOS[rand];
			texto += " " + ADJETIVOS[rand];
			texto += ", ";
		}
		
		System.out.println(texto);
	}
}
