package problem11to20.problem16;

import java.math.BigDecimal;

/**
 * Created by vikranth on 2/25/2016.
 */
public class Problem16 {
  public static void main(String[] args) {
Problem16 problem16 = new Problem16();
    problem16.findSumOfDigits();
  }
  public void findSumOfDigits()
  {
    String x=new BigDecimal(Math.pow(2,1000)).toPlainString();
    double sum = 0;
    for (int i = 0; i <x.length() ; i++) {
      char value =x.charAt(i);
      if(value=='.')break;
      sum+=Double.parseDouble(value+"");
    }
    System.out.println(sum);
  }
}
