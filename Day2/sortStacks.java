package Day2;
import java.util.Stack;

	public class sortStacks {

	    // Main sort function
	    public static void sortStack(Stack<Integer> stack) {
	        if (!stack.isEmpty()) {
	            int top = stack.pop();
	            sortStack(stack);                 // Recursively sort the smaller stack
	            insertInSortedOrder(stack, top);  // Insert the top element back in sorted order
	        }
	    }

	    // Helper function to insert an element into the sorted stack
	    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
	        // Base case: empty stack or element >= top
	        if (stack.isEmpty() || element >= stack.peek()) {
	            stack.push(element);
	        } else {
	            int top = stack.pop();
	            insertInSortedOrder(stack, element);  // Recur until correct spot found
	            stack.push(top);                      // Restore elements back
	        }
	    }

	    // Utility to print stack from top to bottom
	    public static void printStack(Stack<Integer> stack) {
	        for (int i = stack.size() - 1; i >= 0; i--) {
	            System.out.print(stack.get(i) + " ");
	        }
	        System.out.println();
	    }

	    // Test the sort
	    public static void main(String[] args) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(30);
	        stack.push(-5);
	        stack.push(18);
	        stack.push(14);
	        stack.push(-3);

	        System.out.println("Original Stack:");
	        printStack(stack);

	        sortStack(stack);

	        System.out.println("Sorted Stack:");
	        printStack(stack);
	    }
	}
