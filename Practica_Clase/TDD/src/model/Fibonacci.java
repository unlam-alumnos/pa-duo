package model;

public class Fibonacci {
	private static int[] fibo = new int[1000];

	private static int fibonacci(int numero) {
		if (numero < 2)
			return numero;
		return fibonacci(numero - 2) + fibonacci(numero - 1);
	}

	private static int fibonacci2(int n) {
		if (n < 2)
			return n;
		if (fibo[n] == 0){
			fibo[n] = fibonacci2(n - 1) + fibo[n-2];
			return fibo[n];
		}
		return n;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 50; i++) {
			System.out.println(i + " : " + fibonacci2(i));
		}
	}
}
