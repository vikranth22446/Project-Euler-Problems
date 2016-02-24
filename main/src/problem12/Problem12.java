package problem12;


import java.util.ArrayList;

public class Problem12 {

  private static ArrayList<Double> LIST_OF_PRIMES = new ArrayList<>();

  private static int MAX_FACTORS = 500;
  private static double TRIANGULAR_NUMBER_WITH_MAX_FACTORS;

  public static void main(String[] args) {
    Problem12 problem12 = new Problem12();
    TRIANGULAR_NUMBER_WITH_MAX_FACTORS = problem12.findTriangleNumberWithCertainFactor(LIST_OF_PRIMES, MAX_FACTORS);
    System.out.println(TRIANGULAR_NUMBER_WITH_MAX_FACTORS);
  }

  /**
   * Loops through triangle numbers to find the nth Factor
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
      factors = iterateThroughPrimeFactorization(findPrimeFactorization(triangleNumber, listOfPrimes));
    }
    return triangleNumber;
  }

  /**
   *
   * @param primePowers
   * @return
   */
  public int iterateThroughPrimeFactorization(double[] primePowers) {
    int sum =1;
    for (double values : primePowers)
      sum *= (values+1);

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
   * @param triangularNumber
   * @param primes
   * @return
   */
  public double[] findPrimeFactorization(double triangularNumber, ArrayList<Double> primes) {

    if (primes.size() > 0 && primes.get(primes.size() - 1) < Math.sqrt(triangularNumber))
      primes = addPrimes(primes, Math.sqrt(triangularNumber));

    double originalNumber = triangularNumber;
    double[] factorization = new double[primes.size()];

    if (triangularNumber == 1 ) return factorization;
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
   * @param array
   * @param value
   * @return
   */
  private ArrayList<Double> addPrimes(ArrayList<Double> array, double value) {
    for (double currentNumber = array.get(array.size() - 1); array.get(array.size() - 1) < value; currentNumber++) {
      boolean isPrime = true;
      for (Double anArray : array) {
        if (currentNumber % anArray == 0)
          isPrime = false;
      }
      if (isPrime)
        array.add(currentNumber);
    }

    return array;
  }

}
