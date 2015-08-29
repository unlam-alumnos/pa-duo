package edu.unlam.circulos.model;

import org.junit.Assert;
import org.junit.Test;

public class CirculoTest {
	@Test
	public void contieneCoordenada() {
		// Given
		Circulo circulo = new Circulo(1, 2, 2);
		Coordenada coordenada = new Coordenada(2,2);
		
		// When
		boolean contiene = circulo.contieneCoordenada(coordenada);
		
		// Then
		Assert.assertTrue(contiene);
	}
	
	@Test
	public void noContieneCoordenada() {
		// Given
		Circulo circulo = new Circulo(1, 2, 2);
		Coordenada coordenada = new Coordenada(3,4);
		
		// When
		boolean contiene = circulo.contieneCoordenada(coordenada);
		
		// Then
		Assert.assertFalse(contiene);
	}
	
	@Test
	public void noContieneCoordenadaMuyProxima() {
		// Given
		Circulo circulo = new Circulo(1, 2, 2);
		Coordenada coordenada = new Coordenada(2.9,2.9);
		
		// When
		boolean contiene = circulo.contieneCoordenada(coordenada);
		
		// Then
		Assert.assertFalse(contiene);
	}

	@Test
	public void noContieneCirculoLejano() {
		// Given
		Circulo c1 = new Circulo(1, 2, 2);
		Circulo c2 = new Circulo(1, 10, 10);
		
		// When
		boolean contiene = c1.intersectaCirculo(c2);
		
		// Then
		Assert.assertFalse(contiene);
	}
	
	@Test
	public void contieneCirculoPegado() {
		// Given
		Circulo c1 = new Circulo(1, 2, 2);
		Circulo c2 = new Circulo(1, 4, 2);
		
		// When
		boolean contiene = c1.intersectaCirculo(c2);
		
		// Then
		Assert.assertTrue(contiene);
	}
	
	@Test
	public void contieneCirculoIntersectado() {
		// Given
		Circulo c1 = new Circulo(1, 2, 2);
		Circulo c2 = new Circulo(1, 3, 2);
		
		// When
		boolean contiene = c1.intersectaCirculo(c2);
		
		// Then
		Assert.assertTrue(contiene);
	}
}
