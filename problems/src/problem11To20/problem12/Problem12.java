package problem11to20.problem12;


import java.util.ArrayList;

/**
 * Find the Triangular number with 500 factors.
 * Triangular numbers are numbers that are the sum of all the numbers below it.
 */
public class Problem12 {
  /**
   * Given : The number of factors of the triangular numbers this programs needs to find.
   */
  private static int MAX_FACTORS = 500;
  /**
   * Use: a List of Primes
   */
  private static ArrayList<Double> LIST_OF_PRIMES = new ArrayList<>();
  /**
   * Find: TRIANGULAR NUMBER WITH MAX FACTORS
   */
  private static double TRIANGULAR_NUMBER_WITH_MAX_FACTORS;

  public static void main(String[] args) {
    Problem12 problem12 = new Problem12();
    TRIANGULAR_NUMBER_WITH_MAX_FACTORS = problem12.findTriangleNumberWithCertainFactor(LIST_OF_PRIMES, MAX_FACTORS);
    System.out.println(TRIANGULAR_NUMBER_WITH_MAX_FACTORS);
  }

  /**
   * Loops through triangle numbers to find the nth Factor.Also adds the basic triangular numbers 1 and 2
   *
   * @param listOfPrimes A List Of Primes
   * @param maxFactors   The number given in the problem:500
   * @return Returns the TriangleNumber that has MAX_FACTORS
   */
  public double findTriangleNumberWithCertainFactor(ArrayList<Double> listOfPrimes, int maxFactors) {
    listOfPrimes.add(2.0);
    listOfPrimes.add(3.0);
    int factors = 0;
    double triangleNumber = 0;
    for (int indexOfTriangularNumber = 2; factors <= maxFactors; indexOfTriangularNumber++) {
      triangleNumber = findTriangularNumbers(indexOfTriangularNumber);
      factors = findNumberOfFactors(findPrimeFactorization(triangleNumber, listOfPrimes));
    }
    return triangleNumber;
  }

  /**
   * Iterate through the prime factorization given.
   *
   * @param primePowers The powers of the prime given by findPrimeFactors();
   * @return The number of Factors.
   */
  public int findNumberOfFactors(double[] primePowers) {
    int sum = 1;
    for (double values : primePowers)
      sum *= (values + 1);

    return sum;
  }

  /**
   * A triangular number the sum of all the numbers n to 1
   * for ex. n + n-1 + n-2....+ 1
   *
   * @param n The term.
   * @return Return nth triangular number
   */
  public double findTriangularNumbers(int n) {
    return n * (n + 1) / 2;
  }

  /**
   * Finds the prime factorization of the number by creating an array with all the primes.
   * Also adds primes if the last prime is less than Math.sqrt(number)
   *
   * @param triangularNumber Finds a triangular number
   * @param primes           a list of primes
   * @return The prime factorization of the number.
   */
  public double[] findPrimeFactorization(double triangularNumber, ArrayList<Double> primes) {

    if (primes.size() > 0 && primes.get(primes.size() - 1) < Math.sqrt(triangularNumber))
      primes = addPrimes(primes, Math.sqrt(triangularNumber));

    double originalNumber = triangularNumber;
    double[] factorization = new double[primes.size()];

    if (triangularNumber == 1) return factorization;
    //Does the Prime Factorization

    for (int primeNumberIndex = 0; primeNumberIndex < primes.size(); primeNumberIndex++) {
      while (triangularNumber % primes.get(primeNumberIndex) == 0 && primes.get(primeNumberIndex) != originalNumber) {
        triangularNumber /= primes.get(primeNumberIndex);
        factorization[primeNumberIndex]++;
      }

      if (triangularNumber == 1) break;
    }

    return factorization;
  }

  /**
   * Add primes to the current list of primes until it is less than the given value.
   *
   * @param listOfPrimes A list of primes.
   * @param value        The value that is passed.
   * @return Returns a list of primes with an increased
   */
  private ArrayList<Double> addPrimes(ArrayList<Double> listOfPrimes, double value) {
    for (double currentNumber = listOfPrimes.get(listOfPrimes.size() - 1); listOfPrimes.get(listOfPrimes.size() - 1) < value; currentNumber++) {
      boolean isPrime = true;
      for (Double anArray : listOfPrimes) {
        if (currentNumber % anArray == 0)
          isPrime = false;
      }
      if (isPrime)
        listOfPrimes.add(currentNumber);
    }

    return listOfPrimes;
  }

}
