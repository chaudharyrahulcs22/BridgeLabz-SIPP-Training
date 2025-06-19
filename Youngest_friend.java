package Day_3;
import java.util.Scanner;
public class Youngest_friend {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String[] names = {"Amar", "Akbar", "Anthony"};
	        int[] ages = new int[3];
	        double[] heights = new double[3];

	        // Input ages and heights
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Enter age of " + names[i] + ": ");
	            ages[i] = sc.nextInt();

	            System.out.print("Enter height (in cm) of " + names[i] + ": ");
	            heights[i] = sc.nextDouble();
	        }

	        // Find youngest friend
	        int youngestIndex = 0;
	        for (int i = 1; i < 3; i++) {
	            if (ages[i] < ages[youngestIndex]) {
	                youngestIndex = i;
	            }
	        }

	        // Find tallest friend
	        int tallestIndex = 0;
	        for (int i = 1; i < 3; i++) {
	            if (heights[i] > heights[tallestIndex]) {
	                tallestIndex = i;
	            }
	        }

	        // Display results
	        System.out.println("\nThe youngest friend is: " + names[youngestIndex] + " (" + ages[youngestIndex] + " years old)");
	        System.out.println("The tallest friend is: " + names[tallestIndex] + " (" + heights[tallestIndex] + " cm)");

	        sc.close();
	    }
	}
