package problems1To10.problem9;

/**
 * Finds the product of a Pythagorean triple that add up to 1000.
 */
public class Problem9 {
  /**
   * Given: The sum of the parts of the triple add up to 1000.
   */
  private static final int TOTAL_SUM = 1000;
  /**
   * Find: The Product of the pythagorean triple that add up to TOTAL_SUM.
   */
  private static double PRODUCT_OF_TRIPLE;

  public static void main(String[] args) {
    Problem9 problem9 = new Problem9();
    PRODUCT_OF_TRIPLE = problem9.findPythagoreanTripleWithSum(TOTAL_SUM);
    System.out.println(PRODUCT_OF_TRIPLE);
  }

  /**
   * This method finds the pythagorean triple that add to TOTAL_SUM.
   *
   * @param certainSum The number given in the problem: 1000.
   * @return The product of the three numbers. If the number does not exist. Return 0.
   */
  public double findPythagoreanTripleWithSum(double certainSum) {
    for (int a = 0; a < certainSum / 2; a++) {
      for (int b = a; b < certainSum / 2; b++) {
        int c = 1000 - a - b;
        if (a * a + b * b == c * c) {
          return a * b * c;
        }
      }
    }
    return 0;
  }
}
