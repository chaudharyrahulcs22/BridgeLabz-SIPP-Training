package Day_3;
import java.util.Scanner;
public class Check_vote {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int[] ages = new int[10];

	        System.out.println("Enter the ages of 10 students:");

	        for (int i = 0; i < ages.length; i++) {
	            System.out.print("Student " + (i + 1) + " age: ");
	            ages[i] = sc.nextInt();
	        }

	        System.out.println("\nVoting Eligibility Results:");
	        for (int age : ages) {
	            if (age < 0) {
	                System.out.println("Invalid age entered.");
	            } else if (age >= 18) {
	                System.out.println("The student with the age " + age + " can vote.");
	            } else {
	                System.out.println("The student with the age " + age + " cannot vote.");
	            }
	        }

	        sc.close();
	    }
	}
