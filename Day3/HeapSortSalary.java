package Day3;

public class HeapSortSalary {

	    // Heapify a subtree rooted with node i (index) in array of size n
	    public static void heapify(int[] salaries, int n, int i) {
	        int largest = i;        // Initialize largest as root
	        int left = 2 * i + 1;   // left = 2*i + 1
	        int right = 2 * i + 2;  // right = 2*i + 2

	        // If left child is larger than root
	        if (left < n && salaries[left] > salaries[largest]) {
	            largest = left;
	        }

	        // If right child is larger than largest so far
	        if (right < n && salaries[right] > salaries[largest]) {
	            largest = right;
	        }

	        // If largest is not root
	        if (largest != i) {
	            int temp = salaries[i];
	            salaries[i] = salaries[largest];
	            salaries[largest] = temp;

	            // Recursively heapify the affected subtree
	            heapify(salaries, n, largest);
	        }
	    }

	    // Main function to perform Heap Sort
	    public static void heapSort(int[] salaries) {
	        int n = salaries.length;

	        // Build max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(salaries, n, i);
	        }

	        // Extract elements one by one from heap
	        for (int i = n - 1; i >= 0; i--) {
	            // Move current root to end
	            int temp = salaries[0];
	            salaries[0] = salaries[i];
	            salaries[i] = temp;

	            // Call heapify on the reduced heap
	            heapify(salaries, i, 0);
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] expectedSalaries = {55000, 48000, 67000, 53000, 60000, 50000};

	        System.out.println("Original Salary Demands:");
	        for (int salary : expectedSalaries) {
	            System.out.print(salary + " ");
	        }

	        heapSort(expectedSalaries); // Sort the array

	        System.out.println("\n\nSorted Salary Demands in Ascending Order:");
	        for (int salary : expectedSalaries) {
	            System.out.print(salary + " ");
	        }
	    }
	}

