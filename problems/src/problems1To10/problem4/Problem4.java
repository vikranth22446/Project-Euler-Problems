package problems1To10.problem4;


public class Problem4 {
  /**
   * Given: numbers that is three digit which is from the range 100 to 999
   */
  private static final int LOW_RANGE = 100;
  private static final int HIGH_RANGE = 999;
  /**
   * Find: The greatest Palindrome made by multiplying two , three digit numbers.
   */
  private static int GREATEST_PALINDROME = 000;

  public static void main(String[] args) {
    Problem4 problem4 = new Problem4();
    problem4.greatestPalindrome();
    System.out.println(GREATEST_PALINDROME);
  }

  /**
   * this method finds The Greatest Palindrome by looping through all the numbers and multiplying them together.<br></br>
   * Then this method calls isPalindrome() to checks if number is a palindrome.<br></br>
   * If it is and it has the greatest product, then the value is saved.
   */
  public void greatestPalindrome() {
    for (int firstNumber = LOW_RANGE; firstNumber < HIGH_RANGE; firstNumber++) {
      for (int secondNumber = LOW_RANGE; secondNumber < HIGH_RANGE; secondNumber++) {
        if (isPalindrome(new StringBuffer(firstNumber * secondNumber))) {
          if (firstNumber * secondNumber > GREATEST_PALINDROME)
            GREATEST_PALINDROME = firstNumber * secondNumber;
        }
      }
    }
  }

  /**
   * This method checks if the st4ng is a palindrome by splitting the string in half, reverse one side,
   * and then checking if the two sides match
   *
   * @param stringProduct The product of the first and second number
   * @return a boolean that states if string is a palindrome.
   */
  public boolean isPalindrome(StringBuffer stringProduct) {
    int lengthOfProduct = stringProduct.length();
    int halfOfProductLength = lengthOfProduct / 2;
    if (lengthOfProduct % 2 == 0) {
      StringBuffer firstHalf = new StringBuffer(stringProduct.substring(0, halfOfProductLength)).reverse();
      String secondHalf = stringProduct.substring(halfOfProductLength, lengthOfProduct);
      return firstHalf.toString().equalsIgnoreCase(secondHalf);
    } else {
      StringBuffer firstHalf = new StringBuffer(stringProduct.substring(0, halfOfProductLength)).reverse();
      String secondHalf = (stringProduct.substring((int) (halfOfProductLength + 1.5), lengthOfProduct));
      return firstHalf.toString().equalsIgnoreCase(secondHalf);
    }

  }
}
