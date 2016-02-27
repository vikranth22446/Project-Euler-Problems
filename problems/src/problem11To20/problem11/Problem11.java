package problem11to20.problem11;

/**
 * This program finds the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid.
 */
public class Problem11 {
  /**
   * Given: The Grid given in the problem
   */
  public static double[][] GIVEN_GRID = {
      {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
      {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
      {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
      {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
      {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
      {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
      {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
      {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
      {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
      {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
      {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
      {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
      {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
      {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
      {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
      {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
      {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
      {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
      {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
      {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}
  };
  /**
   * Given: the number of numbers to find the products of.
   */
  public static int GIVEN_NUMBER_TO_FIND = 4;

  /**
   * Use: The offsets from the current position of the up,down,left,right, and the diagonals.
   */
  public static int[][] up = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  public static int[][] down = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  public static int[][] left = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  public static int[][] right = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  public static int[][] rightDiagonal = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  public static int[][] leftDiagonal = new int[GIVEN_NUMBER_TO_FIND - 1][2];
  /**
   * The Greatest product of the GIVEN_NUMBER_TO_FIND
   */
  private static double GREATEST_PRODUCT;

  /**
   * Finds the Offset from the current position of the up,down,right,left, and the diagonals.
   */
  public Problem11(double numberToFind) {
    int col1 = 0, col2 = 1;
    for (int row = 0, offset = 1; row < numberToFind - 1; row++, offset++) {
      up[row][col1] = 0;
      up[row][col2] = offset;

      down[row][col1] = 0;
      down[row][col2] = -offset;

      right[row][col1] = offset;
      right[row][col2] = 0;

      left[row][col1] = -offset;
      left[row][col2] = 0;

      leftDiagonal[row][col1] = -offset;
      leftDiagonal[row][col2] = offset;

      rightDiagonal[row][col1] = offset;
      rightDiagonal[row][col2] = -offset;
    }
  }

  /**
   * Checks if the number is on the gird. If it is on the grid the method returns the value else it
   * returns zero.
   *
   * @param row  The row position to check.
   * @param col  The col position to check.
   * @param grid the given grid given in the problem.
   * @return Returns 0 if it is not on grid
   */
  public double valueOnGrid(int row, int col, double[][] grid) {
    if (row >= 20 || row < 0 || col >= 20 || col < 0)
      return 0;
    else return grid[row][col];
  }

  public static void main(String[] args) {
    Problem11 problem11 = new Problem11(GIVEN_NUMBER_TO_FIND);
    GREATEST_PRODUCT = problem11.iterateThroughGrid(GIVEN_GRID, GIVEN_NUMBER_TO_FIND);
    System.out.println(GIVEN_GRID);
  }

  /**
   * Loops through all the positions in the gird, and calculates the greatest value.
   *
   * @param grid The given Grid.
   * @return The greatest v
   */
  public double iterateThroughGrid(double[][] grid, int numberToFind) {
    double greatestProductOfTheCombination = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        double currentValue = runThroughOffsets(row, col, grid, numberToFind);
        if (currentValue > greatestProductOfTheCombination) greatestProductOfTheCombination = currentValue;
      }
    }

    return greatestProductOfTheCombination;
  }

  /**
   * Finds the product of the numbers with different offset and finds the maximum of the pattern.
   *
   * @param currentRow The current position given by iterate through grid.
   * @param currentCol The current position given by iterate through grid.
   * @param grid       The grid given by the problem.
   * @return The Greatest value of the up,down,left,right and the diagonals for each position.
   */
  public double runThroughOffsets(int currentRow, int currentCol, double[][] grid, int numberToFind) {
    double currentValue = grid[currentRow][currentCol];

    double upValue = currentValue;
    double downValue = currentValue;
    double leftValue = currentValue;
    double rightValue = currentValue;
    double rightDiagonalValue = currentValue;
    double leftDiagonalValue = currentValue;

    for (int i = 0; i < numberToFind - 1; i++) {
      upValue *= valueOnGrid(currentRow + up[i][0], currentCol + up[i][1], grid);
      downValue *= valueOnGrid(currentRow + down[i][0], currentCol + down[i][1], grid);
      leftValue *= valueOnGrid(currentRow + left[i][0], currentCol + left[i][1], grid);
      rightValue *= valueOnGrid(currentRow + right[i][0], currentCol + right[i][1], grid);
      rightDiagonalValue *= valueOnGrid(currentRow + rightDiagonal[i][0], currentCol + rightDiagonal[i][1], grid);
      leftDiagonalValue *= valueOnGrid(currentRow + leftDiagonal[i][0], currentCol + leftDiagonal[i][1], grid);
    }

    return Math.max(
        Math.max(upValue, downValue),
        Math.max(
            Math.max(leftValue, rightValue),
            Math.max(leftDiagonalValue, rightDiagonalValue)));
  }
}
