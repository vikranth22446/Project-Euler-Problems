package problems1To10.problem8;

/**
 * This program find the value of the greatest product thirteen adjacent digits.
 */
public class Problem8 {
  /**
   * Given: The Long number used to find greatest product of 13 adjacent numbers
   */
  private static final String GIVEN_NUMBER =
      "73167176531330624919225119674426574742355349194934" +
          "96983520312774506326239578318016984801869478851843" +
          "85861560789112949495459501737958331952853208805511" +
          "12540698747158523863050715693290963295227443043557" +
          "66896648950445244523161731856403098711121722383113" +
          "62229893423380308135336276614282806444486645238749" +
          "30358907296290491560440772390713810515859307960866" +
          "70172427121883998797908792274921901699720888093776" +
          "65727333001053367881220235421809751254540594752243" +
          "52584907711670556013604839586446706324415722155397" +
          "53697817977846174064955149290862569321978468622482" +
          "83972241375657056057490261407972968652414535100474" +
          "82166370484403199890008895243450658541227588666881" +
          "16427171479924442928230863465674813919123162824586" +
          "17866458359124566529476545682848912883142607690042" +
          "24219022671055626321111109370544217506941658960408" +
          "07198403850962455444362981230987879927244284909188" +
          "84580156166097919133875499200524063689912560717606" +
          "05886116467109405077541002256983155200055935729725" +
          "71636269561882670428252483600823257530420752963450";
  /**
   * Find: The greatest product of thirteen adjacent digits.
   */
  private static double GREATEST_PRODUCT;

  public static void main(String[] args) {
    Problem8 problem8 = new Problem8();
    GREATEST_PRODUCT = problem8.findGreatestProduct(GIVEN_NUMBER);
    System.out.println(GREATEST_PRODUCT);
  }

  /**
   * This method loops through thirteen digits at a time. In each of the thirteen digit set the method findProduct
   * is called. The greatest of these products is returned.
   *
   * @param number
   * @return The greatest product of thirteen adjacent numbers.
   */
  public double findGreatestProduct(String number) {
    double greatestNumber = 0;
    for (int i = 0; i + 13 < number.length(); i++) {
      String thirteenDigitString = number.substring(i, i + 13);
      double product = findProduct(thirteenDigitString);
      if (product > greatestNumber)
        greatestNumber = product;
    }
    return greatestNumber;
  }

  /**
   * @param thirteenDigitString
   * @return
   */
  public double findProduct(String thirteenDigitString) {
    double product = 1;
    if (thirteenDigitString.contains("0")) return 0;
    for (int stringIndex = 0; stringIndex < (thirteenDigitString).length(); stringIndex++) {
      product *= Double.parseDouble((thirteenDigitString.charAt(stringIndex) + ""));
    }
    return product;
  }

}
