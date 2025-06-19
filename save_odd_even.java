package Day_3;
import java.util.*;
public class save_odd_even {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Error: Please enter a valid natural number.");
            return;
        }

        // Create arrays for odd and even numbers
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];

        int evenIndex = 0;
        int oddIndex = 0;

        // Loop through numbers from 1 to the user-entered number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i; // Store even number
            } else {
                oddNumbers[oddIndex++] = i; // Store odd number
            }
        }

        // Print odd numbers
        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print even numbers
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        sc.close();
    }
}
