package problem11to20.problem17;

import java.util.*;


public class Problem17 {
  Map<Double, String> myIndex;

  public Problem17() {
    myIndex = new HashMap<>();
    myIndex.put(0.0, "zero");
    myIndex.put(1.0, "one");
    myIndex.put(2.0, "two");
    myIndex.put(3.0, "three");
    myIndex.put(4.0, "four");
    myIndex.put(5.0, "five");
    myIndex.put(6.0, "six");
    myIndex.put(7.0, "seven");
    myIndex.put(8.0, "eight");
    myIndex.put(9.0, "nine");
    myIndex.put(10.0, "ten");
    myIndex.put(11.0, "eleven");
    myIndex.put(12.0, "twelve");
    myIndex.put(13.0, "thirteen");
    myIndex.put(14.0, "fourteen");
    myIndex.put(15.0, "fifteen");
    myIndex.put(16.0, "sixteen");
    myIndex.put(17.0, "seventeen");
    myIndex.put(18.0, "eighteen");
    myIndex.put(19.0, "nineteen");
    myIndex.put(20.0, "twenty");
    myIndex.put(30.0, "thirty");
    myIndex.put(40.0, "forty");
    myIndex.put(50.0, "fifty");
    myIndex.put(60.0, "sixty");
    myIndex.put(70.0, "seventy");
    myIndex.put(80.0, "eighty");
    myIndex.put(90.0, "ninety");
    myIndex.put(100.0, "hundred");
    myIndex.put(1000.0, "thousand");
    myIndex.put(1E+6, "million");
    myIndex.put(1E+9, "billion");
    myIndex.put(1E+12, "trillion");
    myIndex.put(-1.0, "and");
  }

  public static void main(String[] args) {
    Problem17 problem17 = new Problem17();
    problem17.findTotalSumOfWords();
  }

  public void findTotalSumOfWords() {
    int sumOfOneTo9 = 0;
    for (double i = 1.0; i <= 9; i++) {
      sumOfOneTo9 += myIndex.get(i).length();
    }
    int sumOf11To19 = 0;
    for (double i = 10.0; i <= 19; i++) {
      sumOf11To19 += myIndex.get(i).length();
    }
    int sumofOneToHundred = sumOf11To19+sumOfOneTo9;
    for (double i = 20.0; i <= 90; i += 10) {
      sumofOneToHundred += 10*myIndex.get(i).length()+sumOfOneTo9;
    }
    int sumTotal = sumofOneToHundred;
    System.out.println(sumofOneToHundred);

    sumofOneToHundred += sumOfOneTo9*100 +
                          myIndex.get(100.0).length()*9
                        +(myIndex.get(100.0).length() +myIndex.get(-1.0).length())*99*9
                        +sumTotal*9+myIndex.get(1.0).length()+myIndex.get(1000.0).length();

    System.out.println(sumofOneToHundred);

  }

}
