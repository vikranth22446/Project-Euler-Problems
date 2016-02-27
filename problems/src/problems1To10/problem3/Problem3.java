package problems1To10.problem3;

/**
 * This program tries find the greatest prime divisor of a number.
 */
public class Problem3 {
  /**
   * Given: A number to factor:600851475143.0
   */
  private static final double NUMBER_TO_FACTOR = 600851475143.0;
  /**
   * Find: The greatest common factor.
   */
  private static double BIGGEST_PRIME_FACTOR = 0;

  public static void main(String[] args) {
    Problem3 problem3 = new Problem3();
    problem3.calculateGreatestPrime(NUMBER_TO_FACTOR);
    System.out.println(BIGGEST_PRIME_FACTOR);
  }

  /**
   * This method calculates the greatest prime number by bashing through the numbers.
   * <br></br>First this method removes the even numbers, and looks through all the odd numbers
   * for the greatest common factor.
   *
   * @param GivenNum This is the given number to factor:600851475143.0
   */
  public void calculateGreatestPrime(double GivenNum) {
    if (GivenNum % 2 == 0) {
      BIGGEST_PRIME_FACTOR = 2;
      while (GivenNum % 2 == 0)
        GivenNum /= 2;//Reduces all factors of that number
    }
    for (double currentFactor = 3; currentFactor < (int) Math.sqrt(GivenNum); currentFactor = currentFactor + 2) {
      while (GivenNum % currentFactor == 0) {
        GivenNum /= currentFactor; //Reduces Given number by the factor.
        if (currentFactor > BIGGEST_PRIME_FACTOR)
          BIGGEST_PRIME_FACTOR = currentFactor;
      }
    }
    if (GivenNum > BIGGEST_PRIME_FACTOR)
      BIGGEST_PRIME_FACTOR = GivenNum;
  }
}
