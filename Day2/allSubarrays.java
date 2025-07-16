package Day2;
import java.util.*;

	public class allSubarrays {

	    // Function to find all subarrays with zero sum
	    public static List<int[]> findZeroSumSubarrays(int[] arr) {
	        Map<Integer, List<Integer>> sumMap = new HashMap<>();
	        List<int[]> result = new ArrayList<>();
	        int sum = 0;

	        // Add default for sum = 0 at index -1
	        sumMap.put(0, new ArrayList<>());
	        sumMap.get(0).add(-1);

	        for (int i = 0; i < arr.length; i++) {
	            sum += arr[i];

	            if (sumMap.containsKey(sum)) {
	                List<Integer> indices = sumMap.get(sum);
	                for (int startIdx : indices) {
	                    result.add(new int[]{startIdx + 1, i}); // from next of startIdx to i
	                }
	            }

	            // Add current index to the list of the current sum
	            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
	        }

	        return result;
	    }

	    // Utility method to print subarrays
	    public static void printSubarrays(int[] arr, List<int[]> subarrays) {
	        for (int[] range : subarrays) {
	            System.out.print("Subarray [");
	            for (int i = range[0]; i <= range[1]; i++) {
	                System.out.print(arr[i] + (i < range[1] ? ", " : ""));
	            }
	            System.out.println("]");
	        }
	    }

	    // Test the function
	    public static void main(String[] args) {
	        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};

	        System.out.println("Input array: " + Arrays.toString(arr));
	        List<int[]> subarrays = findZeroSumSubarrays(arr);

	        System.out.println("\nZero-sum subarrays:");
	        printSubarrays(arr, subarrays);
	    }
	}