package Day_3;
import java.util.Scanner;
public class Print_table {
	

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.print("Enter a number to print its multiplication table: ");
	        int number = sc.nextInt();
	        
	        int[] table = new int[10];

	        // Fill the table array with results
	        for (int i = 0; i < table.length; i++) {
	            table[i] = number * (i + 1);
	        }

	        // Print the results
	        System.out.println("Multiplication table of " + number + ":");
	        for (int i = 0; i < table.length; i++) {
	            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
	        }

	        sc.close();
	    }
	}
