package edu.unlam.complejo;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		Complejo c1 = new Complejo(2,3);
		Complejo c2 = new Complejo(4,-1);
		Complejo c3 = new Complejo(8,0.5);		
		Complejo c4 = new Complejo(1E-2,-1E2);
		
		Complejo[] complejos = new Complejo[4]; 
		// En memoria lo inicializa en NULL, si fuese variable primitiva por ej int = 0
		
		complejos[0] = c1;
		complejos[1] = c2;
		complejos[2] = c3;
		complejos[3] = c4;
		
		Arrays.sort(complejos);
		
		for (Complejo complejo : complejos) {
			System.out.println(complejo + " Modulo = " + complejo.modulo());
		}

				
		/*
		System.out.println(c1);
		
		Complejo c3 = new Complejo();
		
		System.out.println(c3.num);
		
		Complejo.mostrar();
		Complejo.mostrar("Gonza");
		
		if (c1.equals(c2)) {
			System.out.println("Iguales");
		} else {
			System.out.println("Distintos");
		}
		*/
		/*
		 * JAVA cachea -128 to 127 en memoria para optimizar la utilizacion de enteros
		 * 
		
		Integer a = 127;
		Integer b = 127;
		
		int c = 5;
		int d = 5;
		
		System.out.println(a == b);
		System.out.println(c == d);
		
		System.out.println(c1.sumar(c2));
		System.out.println(c1.restar(c2));
		System.out.println(c1.multiplicar(c2));
		System.out.println(c1.dividir(c2));
		*/
	}

}