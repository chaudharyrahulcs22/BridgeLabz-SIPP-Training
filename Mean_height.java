package Day_3;
import java.util.*;
public class Mean_height {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 double[] heights = new double[11];
		 double sum = 0;

		 System.out.println("Enter the heights of 11 football players:");

		 for (int i = 0; i < heights.length; i++) {
		 System.out.print("Player " + (i + 1) + ": ");
		 heights[i] = sc.nextDouble();
		 sum += heights[i];
		 }

		 double mean = sum / heights.length;
		 System.out.println("The mean height of the football team is: " + mean);
		        
		 sc.close();
	}

}
