package model;

public class ProcesoRunnable implements Runnable{
	private int i;
	
	public void run(){
		i = 0;
		while(true){
			i++;
			System.out.println(i);
		}
	}
}
