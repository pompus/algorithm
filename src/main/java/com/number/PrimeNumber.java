package com.number;

public class PrimeNumber {

	public static void main(String[] args) {
		printPrime(3);
		printPrime(6);
	}

	private static void printPrime(int prime) {
		//1 is not a prime number
		if (prime == 1) {
			System.out.println(prime + " is not prime number");
			return;
		}

		if (prime > 1) {
			boolean isPrime = true;
			for (int i = 2; i <= prime / 2; i++) {
				if (prime % i == 0) {
					isPrime = false;
					System.out.println(prime + " is not prime number");
					break;
				}
			}
			if (isPrime)
				System.out.println(prime + " is prime number");
		}
	}
}