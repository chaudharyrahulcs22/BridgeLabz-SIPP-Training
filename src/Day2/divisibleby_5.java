package Day2;
import java.util.Scanner;
public class divisibleby_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num%5==0) {
			System.out.print("Is the number " + num + "divisible by 5 ?" + true );
		}
		else {
			System.out.print("Is the number " + num + "divisible by 5 ?" + false );
		}
		sc.close();
	}
}
