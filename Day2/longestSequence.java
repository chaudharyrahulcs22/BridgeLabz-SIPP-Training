package Day2;
import java.util.HashSet;

	public class longestSequence {

	    public static int longestConsecutive(int[] nums) {
	        if (nums.length == 0) return 0;

	        HashSet<Integer> numSet = new HashSet<>();
	        for (int num : nums) {
	            numSet.add(num);
	        }

	        int maxLength = 0;

	        for (int num : nums) {
	            // Only try to build sequence if num is the start
	            if (!numSet.contains(num - 1)) {
	                int currentNum = num;
	                int currentLength = 1;

	                while (numSet.contains(currentNum + 1)) {
	                    currentNum++;
	                    currentLength++;
	                }

	                maxLength = Math.max(maxLength, currentLength);
	            }
	        }

	        return maxLength;
	    }

	    // Main method to test
	    public static void main(String[] args) {
	        int[] arr = {100, 4, 200, 1, 3, 2};
	        int result = longestConsecutive(arr);

	        System.out.println("Length of Longest Consecutive Sequence: " + result);
	    }
	}
