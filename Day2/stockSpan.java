package Day2;
import java.util.Stack;

	public class stockSpan {

	    public static int[] calculateSpan(int[] prices) {
	        int n = prices.length;
	        int[] span = new int[n];
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < n; i++) {
	            // Pop all elements from stack smaller or equal to current price
	            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
	                stack.pop();
	            }

	            // If stack is empty, price is greater than all previous days
	            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

	            // Push this day's index to stack
	            stack.push(i);
	        }

	        return span;
	    }

	    // Utility function to print an array
	    public static void printArray(int[] arr) {
	        for (int value : arr) {
	            System.out.print(value + " ");
	        }
	        System.out.println();
	    }

	    // Main function to test the span calculation
	    public static void main(String[] args) {
	        int[] prices = {100, 80, 60, 70, 60, 75, 85};
	        System.out.println("Stock Prices:");
	        printArray(prices);

	        int[] spans = calculateSpan(prices);
	        System.out.println("Stock Spans:");
	        printArray(spans);
	    }
	}
