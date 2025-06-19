package Day_3;
import java.util.*;
public class Multiple_Value {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10]; // Array to store numbers
        double total = 0.0; // Variable to store sum
        int index = 0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();

            // Break if 0 or negative number is entered
            if (num <= 0) {
                break;
            }

            // Store the number if index is within limit
            if (index < 10) {
                numbers[index] = num;
                index++;
            } else {
                break;
            }
        }

        // Display entered numbers and calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i]; // Adding to total
        }

        // Display the total sum
        System.out.println("\nTotal sum: " + total);

        sc.close();
    }
}
