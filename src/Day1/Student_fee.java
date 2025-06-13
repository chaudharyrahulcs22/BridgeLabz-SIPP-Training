package Day1;
import java.util.*;
public class Student_fee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double fee, discountPercent, discountAmount, finalFee;

		System.out.print("Enter the course fee (INR): ");
		fee = input.nextDouble();

		System.out.print("Enter the discount percentage: ");
		discountPercent = input.nextDouble();

		discountAmount = (fee * discountPercent) / 100;
		finalFee = fee - discountAmount;

		System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
		input.close();
	}
}
