package problem11to20.problem18;


import java.util.ArrayList;
import java.util.Scanner;

public class Problem18 {
    private static ArrayList<HeapValue> givenArray = new ArrayList<>();
    private int totalRows = 0;
    private static int maximum = 0;

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        problem18.readInt(givenArray);
        problem18.findTotalRows();
        problem18.findLongestPath(givenArray, problem18.totalRows);
        System.out.println(maximum);
    }

    public void findTotalRows() {
        Scanner scanner;
        scanner = new Scanner(this.getClass().getResourceAsStream("maximumPathProblem.txt"));
        while (scanner.hasNext()) {
            scanner.nextLine();
            totalRows++;
        }
    }

    public void readInt(ArrayList<HeapValue> array) {
        array.add(new HeapValue(0));
        Scanner scanner;
        scanner = new Scanner(this.getClass().getResourceAsStream("maximumPathProblem.txt"));
        while (scanner.hasNext()) {
            array.add(new HeapValue(scanner.nextInt()));
        }
    }

    public void findLongestPath(ArrayList<HeapValue> array, int totalRows) {
        int heapIndex = 1;
        for (int row = 1; row <= totalRows; row++) {
            for (int numItems = row; numItems != 0; numItems--, heapIndex++) {
                if (totalRows != row) {
                    int valueAtCurrentIndex = array.get(heapIndex).getValue();
                    int heapIndexDoubleLeft = array.get(heapIndex + row).getValue();
                    accessedValueLeft(array, valueAtCurrentIndex, heapIndex, heapIndexDoubleLeft, row);
                    accessedValueRight(array, heapIndex, valueAtCurrentIndex, row);
                    array.get(heapIndex + row).setAccessed(true);
                } else {
                    findMaximum(array, heapIndex);
                }
            }
        }
    }

    private void accessedValueRight(ArrayList<HeapValue> array, int heapIndex, int valueAtCurrentIndex, int row) {
        int heapIndexDoubleRight = array.get(heapIndex + row + 1).getValue();
        array.set(heapIndex + row + 1, new HeapValue(valueAtCurrentIndex + heapIndexDoubleRight));
        array.get(heapIndex + row + 1).setAccessed(true);
    }


    private void accessedValueLeft(ArrayList<HeapValue> array, int valueAtCurrentIndex, int heapIndex, int heapIndexDoubleLeft, int rows) {
        if (array.get(heapIndex + rows).getAccessed()) {
            if (array.get(heapIndex).getValue() > array.get(heapIndex - 1).getValue()) {
                array.set(heapIndex + rows, new HeapValue(valueAtCurrentIndex + heapIndexDoubleLeft - array.get(heapIndex - 1).getValue()));
            }
        } else {
            array.set(heapIndex + rows, new HeapValue(valueAtCurrentIndex + heapIndexDoubleLeft));
        }
    }

    private void findMaximum(ArrayList<HeapValue> array, int heapIndex) {
        if (array.get(heapIndex).getValue() > maximum) {
            maximum = array.get(heapIndex).getValue();
        }
    }
}
