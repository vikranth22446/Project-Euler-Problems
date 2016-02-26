package problem15;

/**
 * Created by vikranth on 2/25/2016.
 */
public class Problem15 {

  private static int LENGTH_OF_STREET=20;

  public static void main(String[] args) {
    Problem15 problem15 = new Problem15();
    System.out.println(problem15.MaximumRoutes(LENGTH_OF_STREET));
  }

  /**
   * This is a simple example of permuation, since you cannot repeat positions,
   *
   * @param i
   * @return
   */
  public double MaximumRoutes(int i) {
    double totalNumberOfMovements = 2 * i;
    double picking = i;
    double combination = findFactorial(totalNumberOfMovements) /
        (findFactorial(picking) * findFactorial(totalNumberOfMovements - picking));
    return combination;
  }

  public double findFactorial(double n) {
    if (n == 0) return 1;
    return n*findFactorial(n - 1);
  }
}
