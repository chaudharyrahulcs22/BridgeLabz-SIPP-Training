package Day3;

public class SelectionSortExamScores {

	    // Selection Sort function
	    public static void selectionSort(int[] scores) {
	        int n = scores.length;

	        for (int i = 0; i < n - 1; i++) {
	            // Assume the current index has the minimum
	            int minIndex = i;

	            // Find the minimum in the remaining unsorted array
	            for (int j = i + 1; j < n; j++) {
	                if (scores[j] < scores[minIndex]) {
	                    minIndex = j;
	                }
	            }

	            // Swap the found minimum with the first unsorted element
	            int temp = scores[minIndex];
	            scores[minIndex] = scores[i];
	            scores[i] = temp;
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] examScores = {85, 72, 90, 67, 88, 76};

	        System.out.println("Original Exam Scores:");
	        for (int score : examScores) {
	            System.out.print(score + " ");
	        }

	        selectionSort(examScores); // Sort the array

	        System.out.println("\n\nSorted Exam Scores in Ascending Order:");
	        for (int score : examScores) {
	            System.out.print(score + " ");
	        }
	    }
	}

