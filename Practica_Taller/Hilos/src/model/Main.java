package model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcesoThread p1 = new ProcesoThread();
		ProcesoThread p2 = new ProcesoThread();
		
		p1.c = 'A';
		p2.c = 'B';
		
		p1.start();
		p2.start();
	}

}
