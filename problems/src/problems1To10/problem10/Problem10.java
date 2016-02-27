package problems1to10.problem10;


import java.util.ArrayList;

public class Problem10 {
  /**
   * Given: The amount the primes should be under.
   */
  private static final double TOTAL_SUM = 2 * Math.pow(10, 6);
  /**
   * Find: The sum of all the primes under TOTAL_SUM.
   */
  private static double SUM_OF_PRIMES;

  public static void main(String[] args) {
    Problem10 problem10 = new Problem10();
    SUM_OF_PRIMES = problem10.sumOfArrayList(problem10.findAllPrimesBelowASum(TOTAL_SUM));
    System.out.println(SUM_OF_PRIMES);
  }

  /**
   * Finds the Sum of all the numbers below a given number.
   * @param givenNum The number given in the problem: two million.
   * @return An ArrayList with all the primes below a number
   */
  public ArrayList<Double> findAllPrimesBelowASum(double givenNum) {
    ArrayList<Double> primes = new ArrayList<>();
    primes.add(2.0);
    for (double currentNumber = 3; currentNumber < givenNum; currentNumber += 2) {
      boolean isPrime = true;
      for (int indexOfArraylist = 0; indexOfArraylist < primes.size(); indexOfArraylist++) {
        if (currentNumber % primes.get(indexOfArraylist) == 0)
          isPrime = false;
        if (primes.get(indexOfArraylist) > Math.sqrt(currentNumber))
          break;
      }
      if (isPrime)
        primes.add(currentNumber);
    }
    return primes;
  }

  /**
   * Finds the sum of the ArrayList.
   * @param primes A list of Primes below a certain number(two million).
   * @return A sum of all the primes below a certain number.
   */
  private double sumOfArrayList(ArrayList<Double> primes) {

    double sum = 0;
    for (double primeIndex : primes)
      sum += primeIndex;

    return sum;
  }
}
