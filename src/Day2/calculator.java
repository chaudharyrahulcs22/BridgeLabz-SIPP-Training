package Day2;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter the values of num1 ");
		double num1 = input.nextDouble();
		System.out.print("enter the operation to performed");
		char operator = input.next().charAt(0);
		System.out.print("enter the value of num2");
		double num2 = input.nextDouble();
		double result = 0;
		switch(operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			if(num2 == 0) {
			System.out.print("invalid num2");
			}
			else
			result = num1 / num2;
			break;
		default:
			System.out.print("Invalid operation");
		}
		System.out.print("result = " + result);
		input.close();
	}

}
