package Day_3;
import java.util.Scanner;
public class Find_bonus {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        final int NUM_EMPLOYEES = 10;

	        double[] salaries = new double[NUM_EMPLOYEES];
	        int[] yearsOfService = new int[NUM_EMPLOYEES];
	        double[] bonuses = new double[NUM_EMPLOYEES];
	        double[] newSalaries = new double[NUM_EMPLOYEES];

	        double totalBonus = 0;
	        double totalOldSalary = 0;
	        double totalNewSalary = 0;

	        // Input and validation
	        for (int i = 0; i < NUM_EMPLOYEES; i++) {
	            System.out.println("Enter details for Employee " + (i + 1));

	            // Validate salary
	            System.out.print("Salary: ");
	            double salary = sc.nextDouble();
	            if (salary <= 0) {
	                System.out.println("Invalid salary. Please enter again.");
	                i--;
	                continue;
	            }

	            // Validate years of service
	            System.out.print("Years of service: ");
	            int years = sc.nextInt();
	            if (years < 0) {
	                System.out.println("Invalid years of service. Please enter again.");
	                i--;
	                continue;
	            }

	            salaries[i] = salary;
	            yearsOfService[i] = years;
	        }

	        // Bonus calculation
	        for (int i = 0; i < NUM_EMPLOYEES; i++) {
	            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
	            bonuses[i] = salaries[i] * bonusRate;
	            newSalaries[i] = salaries[i] + bonuses[i];

	            totalBonus += bonuses[i];
	            totalOldSalary += salaries[i];
	            totalNewSalary += newSalaries[i];
	        }

	        // Final output
	        System.out.println("\n📊 Bonus Summary for Zara Employees:");
	        for (int i = 0; i < NUM_EMPLOYEES; i++) {
	            System.out.printf("Employee %d: Old Salary = ₹%.2f, Bonus = ₹%.2f, New Salary = ₹%.2f%n",
	                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
	        }

	        System.out.printf("\nTotal Bonus Payout: ₹%.2f%n", totalBonus);
	        System.out.printf("Total Old Salary of All Employees: ₹%.2f%n", totalOldSalary);
	        System.out.printf("Total New Salary of All Employees: ₹%.2f%n", totalNewSalary);

	        sc.close();
	    }
	}
