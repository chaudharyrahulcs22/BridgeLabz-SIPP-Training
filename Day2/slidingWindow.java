package Day2;
import java.util.*;

	public class slidingWindow {

	    public static int[] maxSlidingWindow(int[] nums, int k) {
	        if (nums == null || k <= 0) return new int[0];

	        int n = nums.length;
	        int[] result = new int[n - k + 1];
	        Deque<Integer> deque = new ArrayDeque<>();

	        for (int i = 0; i < n; i++) {
	            // Remove indices out of the current window from the front
	            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
	                deque.poll();
	            }

	            // Remove indices whose corresponding values are less than nums[i]
	            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
	                deque.pollLast();
	            }

	            // Add current index to the deque
	            deque.offer(i);

	            // If window has hit size k, add the front of deque to result
	            if (i >= k - 1) {
	                result[i - k + 1] = nums[deque.peek()];
	            }
	        }

	        return result;
	    }

	    // Utility function to print array
	    public static void printArray(int[] arr) {
	        for (int val : arr) {
	            System.out.print(val + " ");
	        }
	        System.out.println();
	    }

	    // Main method to test
	    public static void main(String[] args) {
	        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
	        int k = 3;

	        System.out.println("Input array:");
	        printArray(nums);

	        int[] maxValues = maxSlidingWindow(nums, k);

	        System.out.println("Sliding Window Maximum:");
	        printArray(maxValues);
	    }
	}
