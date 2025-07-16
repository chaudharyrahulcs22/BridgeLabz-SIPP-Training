package Day3;

public class BubbleSortStudentMarks {

	    // Bubble sort function
	    public static void bubbleSort(int[] marks) {
	        int n = marks.length;
	        boolean swapped;

	        // Traverse the array
	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;

	            // Compare adjacent elements
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (marks[j] > marks[j + 1]) {
	                    // Swap if the current element is greater than the next
	                    int temp = marks[j];
	                    marks[j] = marks[j + 1];
	                    marks[j + 1] = temp;
	                    swapped = true;
	                }
	            }

	            // If no two elements were swapped in inner loop, break
	            if (!swapped) {
	                break;
	            }
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] studentMarks = {85, 72, 90, 67, 88, 76};

	        System.out.println("Original Marks:");
	        for (int mark : studentMarks) {
	            System.out.print(mark + " ");
	        }

	        bubbleSort(studentMarks); // Sort the array

	        System.out.println("\n\nSorted Marks in Ascending Order:");
	        for (int mark : studentMarks) {
	            System.out.print(mark + " ");
	        }
	    }
	}
