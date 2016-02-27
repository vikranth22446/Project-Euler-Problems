package problems1to10.problem2;

/**
 * This program tries to find the sum of the even Fibonacci numbers not exceeding 4,000,000
 */
public class Problem2 {
    /**
     * Given: The first two numbers in the Fibonacci sequence:1,2.
     * The even number to be under is four million.
     */
    private static final int FIRST_NUMBER = 1;
    private static final int SECOND_NUMBER = 2;
    private static final int NUM_MUST_NOT_EXCEED = 4 * (int) Math.pow(10, 6);
    /**
     * Find the Sum of all the even numbers.
     */
    private static int sumOfEvenNumbers = 0;

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        sumOfEvenNumbers = problem2.findFibonacci(FIRST_NUMBER, SECOND_NUMBER);
        System.out.println(sumOfEvenNumbers);
    }

    /**
     * This method solves this problem recursively by adding all
     * even numbers that is under four million
     *
     * @param firstNum  The first number given in the problem: 1
     * @param secondNum The second number given in the problem: 2
     * @return The sum of all the even fibonacci numbers less than four million
     */
    public int findFibonacci(int firstNum, int secondNum) {
        if (secondNum % 2 == 0 && secondNum > NUM_MUST_NOT_EXCEED) return 0;
        else if (secondNum % 2 == 0 && secondNum < NUM_MUST_NOT_EXCEED)
            return secondNum + findFibonacci(secondNum, firstNum + secondNum);
        else return findFibonacci(secondNum, firstNum + secondNum);
    }
}
