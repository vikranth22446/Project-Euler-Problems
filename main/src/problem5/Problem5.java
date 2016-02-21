package problem5;


import java.util.ArrayList;

/**
 * This program finds the smallest positive number that is evenly divisible by all of the numbers from 1 to 20.
 */
public class Problem5 {
  /**
   * Given: The Number of items:20
   */
  private static final int NUM_ITEMS = 20;
  /**
   * Find: The LCM_OF_ALL_NUMBER below NUM_ITEMS.
   */
  private static double LCM_OF_ALL_NUMBERS;

  public static void main(String[] args) {
    Problem5 problem5 = new Problem5();
    LCM_OF_ALL_NUMBERS = problem5.calculate(NUM_ITEMS);
    System.out.println(LCM_OF_ALL_NUMBERS);
  }

  /**
   * This method brings all the other methods together. It calculates the lcm of the numbers by first
   * finding the primes by calling findAllPrimesBelowNumber(numberofItems). Then Figures out the greatest power of each number.
   *
   * @param numberofItems The number of items given by problem.
   * @return The LCM of all the numbers.
   */
  public double calculate(int numberofItems) {
    ArrayList<Double> listOfPrimes = findAllPrimesBelowNumber(numberofItems);
    double[] greatestPrime = findPrimeFactorization(numberofItems, listOfPrimes);
    return lcmWithPrimeFactorization(listOfPrimes, greatestPrime);
  }

  /**
   * This method finds the prime factorization of each number below NUMBER_OF_ITEMS and
   * by looping through all the numbers and prime numbers, and uses it to find the greatest power of the prime numbers.
   *
   * @param numberOfItems The number of items given in the problem:20.
   * @param primes        The list of all the prime numbers below numberOfItems
   * @return The greatest power of prime given with all numbers below NUMBER_OF_ITEMS/
   */
  public double[] findPrimeFactorization(int numberOfItems, ArrayList<Double> primes) {
    double[] greatestPowerOfPrime = new double[primes.size()];
    for (int i = 2; i < numberOfItems; i++) {//Starts with 2 because 1,0 don't count as primes
      int valueOfI = i;
      double[] tempPowerOfPrimeForEachNumber = new double[primes.size()];
      for (int primeNumberIndex = 0; primeNumberIndex < primes.size(); primeNumberIndex++) {
        if (valueOfI % primes.get(primeNumberIndex) == 0) {
          while (valueOfI % primes.get(primeNumberIndex) == 0) {
            valueOfI /= primes.get(primeNumberIndex);
            tempPowerOfPrimeForEachNumber[primeNumberIndex]++;
          }
          if (i == 1) break;
        }
        greatestPowerOfPrime = findGreaterOFTwoArrays(greatestPowerOfPrime, tempPowerOfPrimeForEachNumber);
      }
    }
    return greatestPowerOfPrime;
  }

  /**
   * This method finds the lcm by multiplying the greatest power of prime numbers together
   *
   * @param primes The prime numbers below NUMBER_OF_ITEMS
   * @param powers The greatest power of prime number.
   * @return The lcm of the numbers below NUMBER_OF_ITEMS.
   */
  public double lcmWithPrimeFactorization(ArrayList<Double> primes, double[] powers) {
    int totalSum = 1;
    for (int primeNumberIndex = 0; primeNumberIndex < primes.size(); primeNumberIndex++) {
      totalSum *= Math.pow(primes.get(primeNumberIndex), powers[primeNumberIndex]);
    }
    return totalSum;
  }

  /**
   * Finds the greatest number of times a prime number occurs.
   *
   * @param mainArray The array with greatest power of primes for the numbers.
   * @param tempArray The array with powers of prime for one number.
   * @return The greatest power of prime for the numbers.
   */
  public double[] findGreaterOFTwoArrays(double[] mainArray, double[] tempArray) {
    for (int k = 0; k < mainArray.length; k++) {
      if (tempArray[k] > mainArray[k])
        mainArray[k] = tempArray[k];
    }
    return mainArray;
  }

  /**
   * Finds all the prime numbers below a given number
   *
   * @param givenNum The number given in the problem:20.
   * @return A list of prime numbers.
   */
  public ArrayList<Double> findAllPrimesBelowNumber(double givenNum) {
    ArrayList<Double> primes = new ArrayList<>();
    for (double currentNumber = 2; currentNumber <= givenNum; currentNumber++) {
      boolean isPrime = true;
      for (int indexOfArraylist = 0; indexOfArraylist < primes.size(); indexOfArraylist++) {
        if (currentNumber % primes.get(indexOfArraylist) == 0)
          isPrime = false;
      }
      if (isPrime)
        primes.add(currentNumber);
    }
    return primes;
  }

}
