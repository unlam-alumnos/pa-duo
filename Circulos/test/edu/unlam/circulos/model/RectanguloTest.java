package edu.unlam.circulos.model;

import org.junit.Assert;
import org.junit.Test;

public class RectanguloTest {
	@Test
	public void contieneCoordenada() {
		// Given
		Rectangulo r1 = new Rectangulo(new Coordenada(1,0), new Coordenada(0,2));
		Coordenada dot = new Coordenada(1,0);
		
		// When
		boolean contiene = r1.contieneCoordenada(dot);
		
		// Then
		Assert.assertTrue(contiene);
	}
	
	@Test
	public void noContieneCoordenada() {
		// Given
		Rectangulo r1 = new Rectangulo(new Coordenada(1,0), new Coordenada(0,2));
		Coordenada dot = new Coordenada(1,3);
		
		// When
		boolean contiene = r1.contieneCoordenada(dot);
		
		// Then
		Assert.assertFalse(contiene);
	}
}
