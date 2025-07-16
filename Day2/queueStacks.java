package Day2;
import java.util.*;
public class queueStacks {
	    private Stack<Integer> stack1; // For enqueue
	    private Stack<Integer> stack2; // For dequeue

	    public queueStacks() {
	        stack1 = new Stack<>();
	        stack2 = new Stack<>();
	    }

	    // Enqueue operation - O(1)
	    public void enqueue(int x) {
	        stack1.push(x);
	    }

	    // Dequeue operation - Amortized O(1)
	    public int dequeue() {
	        if (isEmpty()) {
	            throw new RuntimeException("Queue is empty");
	        }

	        if (stack2.isEmpty()) {
	            transferStack1ToStack2();
	        }

	        return stack2.pop();
	    }

	    // Peek operation - see front element without removing it
	    public int peek() {
	        if (isEmpty()) {
	            throw new RuntimeException("Queue is empty");
	        }

	        if (stack2.isEmpty()) {
	            transferStack1ToStack2();
	        }

	        return stack2.peek();
	    }

	    // Check if queue is empty
	    public boolean isEmpty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }

	    // Helper: transfer all elements from stack1 to stack2
	    private void transferStack1ToStack2() {
	        while (!stack1.isEmpty()) {
	            stack2.push(stack1.pop());
	        }
	    }

	    // Main method to test the queue
	    public static void main(String[] args) {
	        queueStacks queue = new queueStacks();

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);

	        System.out.println(queue.dequeue()); // 10
	        System.out.println(queue.peek());    // 20
	        queue.enqueue(40);
	        System.out.println(queue.dequeue()); // 20
	        System.out.println(queue.dequeue()); // 30
	        System.out.println(queue.dequeue()); // 40

	        System.out.println(queue.isEmpty()); // true
	    }
	}
