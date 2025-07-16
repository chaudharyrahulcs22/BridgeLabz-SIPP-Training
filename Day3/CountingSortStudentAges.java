package Day3;

public class CountingSortStudentAges {

	    public static void countingSort(int[] ages) {
	        int minAge = 10;
	        int maxAge = 18;
	        int range = maxAge - minAge + 1;

	        // Step 1: Create a count array
	        int[] count = new int[range];

	        // Step 2: Store the frequency of each age
	        for (int age : ages) {
	            count[age - minAge]++;
	        }

	        // Step 3: Compute cumulative frequency
	        for (int i = 1; i < range; i++) {
	            count[i] += count[i - 1];
	        }

	        // Step 4: Build the output array
	        int[] output = new int[ages.length];
	        for (int i = ages.length - 1; i >= 0; i--) {
	            int age = ages[i];
	            int index = count[age - minAge] - 1;
	            output[index] = age;
	            count[age - minAge]--;
	        }

	        // Step 5: Copy sorted data back to original array
	        for (int i = 0; i < ages.length; i++) {
	            ages[i] = output[i];
	        }
	    }

	    public static void main(String[] args) {
	        int[] studentAges = {12, 17, 10, 15, 14, 12, 13, 18, 11};

	        System.out.println("Original Student Ages:");
	        for (int age : studentAges) {
	            System.out.print(age + " ");
	        }

	        countingSort(studentAges); // Sort the ages

	        System.out.println("\n\nSorted Student Ages in Ascending Order:");
	        for (int age : studentAges) {
	            System.out.print(age + " ");
	        }
	    }
	}
