package problem12;


import problem5.Problem5;

import java.util.ArrayList;

public class Problem12 {
    private static ArrayList<Double> LIST_OF_PRIMES = new ArrayList<Double>();

    private static double ANSWER;

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        ANSWER = problem12.iterateTriangleNumbers();
        System.out.println(ANSWER);
    }

    public double iterateTriangleNumbers() {
        LIST_OF_PRIMES.add(2.0);
        LIST_OF_PRIMES.add(3.0);
        for (int indexOfTriangularNumber = 2; ; indexOfTriangularNumber++) {
            double triangleNumber = findTriangularNumbers(indexOfTriangularNumber);
            int factors = iterateThroughPrimeFactorization(findPrimeFactorization(triangleNumber, LIST_OF_PRIMES));
            System.out.println(factors);
            if (factors == 500) return triangleNumber;
        }

    }

    public int iterateThroughPrimeFactorization(double[] array) {
        int sum = 2;
        for (int indexOfArray = 0; indexOfArray < array.length; indexOfArray++) {
            sum += array[indexOfArray];
            for (int tempOfCombinedFactors = (int) array[indexOfArray]; tempOfCombinedFactors % 2 == 0 &&
                    tempOfCombinedFactors != 0; tempOfCombinedFactors -= 2) {
                sum++;
            }
        }
        return sum;
    }

    public double findTriangularNumbers(int n) {
        return n * (n + 1) / 2;
    }

    public double[] findPrimeFactorization(double numberOfItems, ArrayList<Double> primes) {
        double orginalNumber = numberOfItems;
        while (primes.get(primes.size() - 1) < Math.sqrt(numberOfItems)) {
            primes = addPrimes(primes, Math.sqrt(numberOfItems));
        }
        double[] factorization = new double[primes.size()];
        if (numberOfItems == 1) return factorization;
        for (int primeNumberIndex = 0; primeNumberIndex < primes.size(); primeNumberIndex++) {
            while (numberOfItems % primes.get(primeNumberIndex) == 0 && primes.get(primeNumberIndex) != orginalNumber) {

                numberOfItems /= primes.get(primeNumberIndex);
                factorization[primeNumberIndex]++;
            }
            if (numberOfItems == 1) break;
        }
        return factorization;
    }

    private ArrayList<Double> addPrimes(ArrayList<Double> array, double value) {
        for (double currentNumber = array.get(array.size() - 1); array.get(array.size() - 1) < value; currentNumber++) {
            boolean isPrime = true;
            for (int indexOfArrayList = 0; indexOfArrayList < array.size(); indexOfArrayList++) {
                if (currentNumber % array.get(indexOfArrayList) == 0)
                    isPrime = false;
            }
            if (isPrime)
                array.add(currentNumber);
        }
        return array;
    }

}
