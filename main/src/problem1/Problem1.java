package problem1;

import java.math.BigInteger;

/**
 * This program tries to find the sum of all the multiples of 3 or 5 below 1000.
 * example scenario: sum of all multiples of 3 or 5 below 10 is 3+5+6+9 = 23.
 */
public class Problem1 {
  /**
   * Given: 2 multiples: 3 and 5. Each multiple must be below 1000.
   */
  private static final int FIRST_MULTIPLE = 3;
  private static final int SECOND_MULTIPLE = 5;
  private static final int MULTIPLES_TO_BE_BELOW = 1000;
  /**
   * Find: The problem asks for the sumOfMultiples
   */
  private static int sumOfMultiples = 0;

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();
    problem1.calculateSumOfMultiples(MULTIPLES_TO_BE_BELOW, FIRST_MULTIPLE,
                                    SECOND_MULTIPLE);
    System.out.println(sumOfMultiples);
  }

  /**
   *This method uses the concept of arithmetic series. This method uses the formulas<br />
   * <ul>
   *    <li> Sn=n/2 * (An + A1) : Sum of a arithmetic series is the number of terms/2 times
   *    the last term + the first term.
   *    </li>
   *    <li> An=A1+(n-1) : Last Term in an arithmetic series is the first term
   *    + (number of terms -1) * the difference between the terms
   *    </li>
   *
   *</ul>
   * With these Formulas the method finds the sum of the FIRST_MULTIPLE
   * below MULTIPLES_TO_BE_BELOW.<br />This process is repeated for both Multiples.
   * This method then finds the sum of the common multiples(LCM) and subtracts it.
   *
   * @param numberToBeBelow The number to below given in this problem:1000
   * @param firstMultiple The First Multiple given in this problem:3
   * @param secondMultiple The Second Multiple given in this problem:5
   * @return The Sum of the multiples of 3 and 5 below 100
   */
  public int calculateSumOfMultiples(int numberToBeBelow, int firstMultiple, int secondMultiple) {

    int lastTermInFistSeries = (numberToBeBelow / firstMultiple) * firstMultiple;//gives last term because of Casting
    int numTerms = ((lastTermInFistSeries - firstMultiple) / firstMultiple) + 1;
    int sumOfFirstMultiples = (int) ((numTerms / 2.0) * (firstMultiple + lastTermInFistSeries));

    if (lastTermInFistSeries == numberToBeBelow)
      sumOfMultiples -= lastTermInFistSeries;

    //The Sum of the Second Numner
    int nthTermOfMultiple2 = (numberToBeBelow / secondMultiple) * secondMultiple;
    int numTerms2 = ((nthTermOfMultiple2 - secondMultiple) / secondMultiple) + 1;
    int sumOfFirstMultiples2 = (int) ((numTerms2 / 2.0) * (double) (secondMultiple + nthTermOfMultiple2));
    sumOfMultiples = sumOfFirstMultiples + sumOfFirstMultiples2;

    if (nthTermOfMultiple2 == numberToBeBelow)
      sumOfMultiples -= nthTermOfMultiple2;


    int lcm = findLCM(firstMultiple, secondMultiple);
    int nthTermOfMultipleLCM = (numberToBeBelow / lcm) * lcm;
    int numTermsLCM = ((nthTermOfMultipleLCM - lcm) / lcm) + 1;
    int sumofLCM = (int) ((numTermsLCM / 2.0) * (nthTermOfMultipleLCM + lcm));
    sumOfMultiples -= sumofLCM;

    return sumOfMultiples;
  }

  /**
   * This method uses the formula<br />
   * LCM(a,b) = a*b/(GCD(a,b)): The Least common multiple is the product of the two terms divided
   * by the GCD.
   * @param firstTerm The first Term in the series
   * @param secondTerm
   * @return The LCM of the first and second term.
   */
  public int findLCM(int firstTerm, int secondTerm) {

    BigInteger gcd = BigInteger.valueOf(firstTerm).gcd(BigInteger.valueOf(secondTerm));
    return firstTerm*secondTerm/(gcd.intValue());
  }


}
