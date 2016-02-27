package problems1to10.problem6;

/**
 * Find the difference between square of a sum and the sums of a square
 */
public class Problem6 {
  /**
   * Given: The terms are from 1-100 so there are 100 terms
   */
  private static final int NUM_TERMS = 100;
  /**
   * The difference between square of a sum and the sums of a square
   */
  private static double ANSWER;

  public static void main(String[] args) {
    Problem6 problem6 = new Problem6();
    ANSWER = problem6.findDifference(NUM_TERMS);
    System.out.println(ANSWER);
  }

  /**
   * This method finds the diffence between the two numbers using the two formulas by realizing that
   * <br></br> the square of sums is 	(&Sigma; of k) ^ 2
   * <br></br>   and the sum of squares is (&Sigma; of k ^ 2 )
   * To solve the two difference the formula used is
   * <br></br>
   * <ul>
   * <li>(&Sigma; of k )^2 = ((number of numbers*(number of numbers + 1)) / 2) ^ 2 </li>
   * <li>(&Sigma; of k ^ 2 ) = number of items*(number of items+1)*(2 * number of items + 1)/6 </li>
   * </ul>
   *
   * @param n The number of items
   */
  public double findDifference(double n) {
    double squaresOfSum = Math.pow(n * (n + 1) / 2, 2);
    double sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;
    return squaresOfSum - sumOfSquares;
  }
}
