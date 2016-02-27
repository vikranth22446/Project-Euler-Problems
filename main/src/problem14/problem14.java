package problem14;


import java.util.ArrayList;

public class Problem14 {
  private final static double NUMBER_TO_BE_UNDER = 1E+6;

  private static double GREATEST_NUMBER_WITH_GREATEST_LINK;

  public static void main(String[] args) {
    Problem14 problem14 = new Problem14();
    GREATEST_NUMBER_WITH_GREATEST_LINK = problem14.calculateGreatestNumberLinks(NUMBER_TO_BE_UNDER);
    System.out.println(GREATEST_NUMBER_WITH_GREATEST_LINK);
  }

  /**
   * Finds the greatest number of links by iterating through all the numbers, and to speed up time
   * add numbers to arrayList to get later.
   *
   * @param nunberToBeUnder the number of numbers to be under given by the problem.
   * @return Return the greatest Number of Links found from 1 to numberToBeUnder.
   */
  public double calculateGreatestNumberLinks(double nunberToBeUnder) {
    /*
       The number of links given a index of a certain number.
     */
    ArrayList<Double> numberLinks = new ArrayList<>();

    double greatestLink = 0, greatestNumber = 0;
    for (int currentNumber = 0; currentNumber <= nunberToBeUnder; currentNumber++) {
      double currentLink = 1;
      double nextNumberInChain = findNextNumberInChain(currentNumber);
      
      if (nextNumberInChain == 1) currentLink++;
      while (!(nextNumberInChain == 1) && nextNumberInChain != 0) {
        if (nextNumberInChain < numberLinks.size()) {
          currentLink += numberLinks.get((int) nextNumberInChain);
          break;
        } else {
          nextNumberInChain = findNextNumberInChain(nextNumberInChain);
          currentLink++;
          if (nextNumberInChain == 1) currentLink++;
        }
      }
      
      numberLinks.add(currentLink);
      if (greatestLink < currentLink) {
        greatestLink = currentLink;
        greatestNumber = currentNumber;
      }

    }
    return greatestNumber;
  }

  /**
   * Finds the next number to chain.
   *
   * @param number the currentLink passed.
   * @return Return the next number in the chain.
   */
  public double findNextNumberInChain(double number) {
    if (number == 1 | number == 0) return 0;
    else if (number % 2 == 0) return number / 2;
    else return 3 * number + 1;
  }
}
