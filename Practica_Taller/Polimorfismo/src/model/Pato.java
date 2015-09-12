package model;

public class Pato implements Nadador, Corredor, Volador{
	
	@Override
	public void volar() {
		// TODO Auto-generated method stub
		System.out.println("El pato vuela");
	}

	@Override
	public void correr() {
		// TODO Auto-generated method stub
		System.out.println("El pato corre");
	}

	@Override
	public void nadar() {
		// TODO Auto-generated method stub
		System.out.println("El pato nada");		
	}

}
