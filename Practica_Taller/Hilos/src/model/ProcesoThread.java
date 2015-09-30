package model;

public class ProcesoThread extends Thread{
	private int i;
	public char c;
	
	public void run(){
		i = 0;
		while(true){
			i++;
			System.out.println(c + " - " + i);
		}
	}
}
