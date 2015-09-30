package test;

import java.util.ArrayList;
import java.util.List;

import model.Punto;
import model.Punto2D;
import model.Punto3D;

import org.junit.Test;

public class PuntosTest {
	
	@Test
	public void testSomething() {
		Punto2D p1 = new Punto2D(4, 5);
		Punto3D p2 = new Punto3D(1, 2, 3);
		Punto p3 = new Punto2D(0.5, 0.5);
		Punto p4 = new Punto3D(-1,-1,-1);
		
		List<Punto> puntos = new ArrayList<Punto>();
		puntos.add(p1);
		puntos.add(p2);
		puntos.add(p3);
		puntos.add(p4);
		
		for (Punto punto : puntos) {
			System.out.println(punto);
		}
	}
}
