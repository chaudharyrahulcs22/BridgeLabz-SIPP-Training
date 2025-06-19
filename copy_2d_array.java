package Day_3;
import java.util.*;
public class copy_2d_array {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Take user input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        // Create a 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Take user input for matrix values
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create a 1D array to copy elements
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Display the 1D array
        System.out.println("\nElements copied to 1D array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();

	}

}
