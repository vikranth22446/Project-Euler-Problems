package problem11To20.problem15;

/**
 * Find the Maximum Routs in a grid.
 */
public class Problem15 {
  /**
   * Given: The lenght of street is 20. In a grid of 20x20.
   */
  private static final int LENGTH_OF_STREET=20;
  /**
   * Find: The Maximum Routes to the end point.
   */
  private static double MAXIMUM_ROUTES;
  public static void main(String[] args) {
    Problem15 problem15 = new Problem15();
    MAXIMUM_ROUTES = problem15.MaximumRoutes(LENGTH_OF_STREET);
    System.out.println(MAXIMUM_ROUTES);
  }

  /**
   * This is a simple example of combination. There are a total of 2x options and a pick of x
   * so the combination is (2x)!/x!/x!
   *
   * @param streetLength The length of the street given.
   * @return The Maximum Routes given.
   */
  public double MaximumRoutes(int streetLength) {
    double totalNumberOfMovements = 2 * streetLength;
    double picking = streetLength;
    double combination = findFactorial(totalNumberOfMovements) /
        (findFactorial(picking) * findFactorial(totalNumberOfMovements - picking));
    return combination;
  }

  /**
   * Finds the factorial of a number
   * @param n The number passed in by Maximum rights
   * @return The factorial of the number
   */
  public double findFactorial(double n) {
    if (n == 0) return 1;
    return n*findFactorial(n - 1);
  }
}
