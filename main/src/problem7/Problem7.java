package problem7;

import java.util.ArrayList;

/**
 * Finds the 10001st prime number
 */
public class Problem7 {
  /**
   * Given: The index of the prime number.
   */
  private static final int PRIME_INDEX = 10001;
  /**
   * Find the prime at PRIME_INDEX
   */
  private static ArrayList<Double> PRIMES;

  public static void main(String[] args) {
    Problem7 problem7 = new Problem7();
    PRIMES = problem7.findAllPrimesBelowANumber(PRIME_INDEX);
    System.out.println(PRIMES.get(PRIMES.size() - 1));
  }

  /**
   * Finds all the prime numbers below a given number
   *
   * @param primeNumbersIndex The index of the prime number to find: 10001
   * @return An ArrayList with all the prime numbers.
   */
  public ArrayList<Double> findAllPrimesBelowANumber(double primeNumbersIndex) {
    ArrayList<Double> primes = new ArrayList<>();
    primes.add(2.0);
    for (double currentNumber = 3; primes.size() != primeNumbersIndex; currentNumber = currentNumber + 2) {
      boolean isPrime = true;
      for (Double prime : primes) {
        if (currentNumber % prime == 0)
          isPrime = false;
        if(prime > Math.sqrt(currentNumber))break;
      }
      if (isPrime)
        primes.add(currentNumber);
    }

    return primes;
  }
}
