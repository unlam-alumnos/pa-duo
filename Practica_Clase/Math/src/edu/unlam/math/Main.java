package edu.unlam.math;

import model.MatrizMath;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrizMath matriz = new MatrizMath(3,3);
		
		matriz.add(0,0,1);
		matriz.add(0,1,3);
		matriz.add(0,2,4);
		matriz.add(1,0,2);
		matriz.add(1,1,2);
		matriz.add(1,2,5);
		matriz.add(2,0,1);
		matriz.add(2,1,0);
		matriz.add(2,2,2);
		
		System.out.println(matriz.getDeterminante());
	}

}
