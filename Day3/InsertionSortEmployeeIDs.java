package Day3;

public class InsertionSortEmployeeIDs {

	    // Insertion sort function
	    public static void insertionSort(int[] employeeIDs) {
	        int n = employeeIDs.length;

	        for (int i = 1; i < n; i++) {
	            int key = employeeIDs[i];   // Element to be inserted
	            int j = i - 1;

	            // Move elements of employeeIDs[0..i-1] that are greater than key
	            // to one position ahead of their current position
	            while (j >= 0 && employeeIDs[j] > key) {
	                employeeIDs[j + 1] = employeeIDs[j];
	                j--;
	            }
	            employeeIDs[j + 1] = key;  // Insert key at correct position
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] employeeIDs = {104, 101, 120, 115, 108};

	        System.out.println("Original Employee IDs:");
	        for (int id : employeeIDs) {
	            System.out.print(id + " ");
	        }

	        insertionSort(employeeIDs); // Sort the array

	        System.out.println("\n\nSorted Employee IDs in Ascending Order:");
	        for (int id : employeeIDs) {
	            System.out.print(id + " ");
	        }
	    }
	}
