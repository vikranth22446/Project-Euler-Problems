package problem14;


import java.util.ArrayList;

public class Problem14 {
  ArrayList<Double> numberLinks = new ArrayList<>();

  public static void main(String[] args) {
    Problem14 problem14 = new Problem14();
    System.out.println(1E+6);
    problem14.calculateNumberLinks();
  }

  public void calculateNumberLinks() {
    double currentLink = 0;
    double greatestLink = 0;
    double greatestNumber = 0;
    for (int i = 0; i <= 1E+6; i++) {
      currentLink = 1;

      double value = findN(i);
      if(value==1)currentLink++;
      while (!(value == 1) && value != 0) {

        if (value < numberLinks.size()) {
          currentLink += numberLinks.get((int)value);
          break;
        }
        else {
          value = findN(value);
          currentLink++;
          if(value==1)currentLink++;
        }
      }
      numberLinks.add(currentLink);
      if(greatestLink<currentLink){
        greatestLink = currentLink;
      greatestNumber = i;
      }
      System.out.println(numberLinks.get(i));
    }
    System.out.println(greatestNumber);
  }

  public double findN(double n) {
    if (n == 1 | n == 0) return 0;
    else if (n % 2 == 0) return n / 2;
    else return 3 * n + 1;
  }
}
