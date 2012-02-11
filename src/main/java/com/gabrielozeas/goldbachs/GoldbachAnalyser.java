package com.gabrielozeas.goldbachs;

import java.util.ArrayList;
import java.util.List;

/**
 * Analyse the primes that summed returns the number espeficied.
 * 
 * @author Gabriel Ozeas de Oliveira <gabriel.ozeas1@gmail.com>
 * 
 */
public class GoldbachAnalyser {

	/**
	 * Retrieve a {@code String} that contains a sum of primes that the result
	 * is the number passed.
	 * 
	 * @param number
	 */
	public String[] analyseConjecture(int number) {
		List<String> summs = new ArrayList<String>();

		Integer[] primes = retrievePrimes(number);
		if (primes.length > 2) {
			/*
			 * 2 primes less than the half of the number never wont produce the
			 * number. So we just need to iterate until the half and sum with all
			 * the other side of the list.
			 */
			
			for (int leftPrimeIndex = 0; leftPrimeIndex <= (primes.length / 2) + 1; leftPrimeIndex++) {
				for (int rightPrimeIndex = primes.length - 1; rightPrimeIndex >= leftPrimeIndex; rightPrimeIndex--) {
					// If the left and rifht numbers sum result in the number, add
					// it.
					if (primes[leftPrimeIndex] + primes[rightPrimeIndex] == number) {
						summs.add(primes[leftPrimeIndex] + " + "
								+ primes[rightPrimeIndex]);
					}
				}
			}
		
		}
		return summs.toArray(new String[summs.size()]);
	}

	/**
	 * Retrieve all prime number until number passed as parameter.
	 * 
	 * @param number
	 *            Number that will be the limit of the primes.
	 * @return A {@code Integer} array contains all the primes calculated.
	 */
	private Integer[] retrievePrimes(int number) {
		/*
		 * Retrieve primes using the sieve of eratosthenes.
		 */
		boolean[] notPrimes = new boolean[number + 1];

		// Iterate until the square of the limit number.
		for (int i = 2; i * i <= number; i++) {
			// For each number, discover the multiples in the range.
			for (int j = 0; j < notPrimes.length; j++) {
				/*
				 * If the number in the range is different from the factor and
				 * is is multiple of factor, so it is not a primes number.
				 */
				if (i != j && j % i == 0) {
					notPrimes[j] = true;
				}
			}
		}

		/*
		 * Now that we have all the primes numbers, we will separate it in a
		 * list.
		 */
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 1; i < notPrimes.length; i++) {
			if (!notPrimes[i]) {
				primes.add(i);
			}
		}
		return primes.toArray(new Integer[primes.size()]);

	}

}
