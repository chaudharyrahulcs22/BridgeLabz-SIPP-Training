package Day3;

public class MergeSortBookPrices {

	    // Merge Sort function
	    public static void mergeSort(int[] prices, int left, int right) {
	        if (left < right) {
	            int mid = (left + right) / 2;

	            // Recursively sort both halves
	            mergeSort(prices, left, mid);
	            mergeSort(prices, mid + 1, right);

	            // Merge the sorted halves
	            merge(prices, left, mid, right);
	        }
	    }

	    // Merge function
	    public static void merge(int[] prices, int left, int mid, int right) {
	        int n1 = mid - left + 1;  // Size of left half
	        int n2 = right - mid;     // Size of right half

	        // Create temporary arrays
	        int[] leftArray = new int[n1];
	        int[] rightArray = new int[n2];

	        // Copy data to temp arrays
	        for (int i = 0; i < n1; i++) {
	            leftArray[i] = prices[left + i];
	        }
	        for (int j = 0; j < n2; j++) {
	            rightArray[j] = prices[mid + 1 + j];
	        }

	        // Merge the two arrays
	        int i = 0, j = 0, k = left;

	        while (i < n1 && j < n2) {
	            if (leftArray[i] <= rightArray[j]) {
	                prices[k++] = leftArray[i++];
	            } else {
	                prices[k++] = rightArray[j++];
	            }
	        }

	        // Copy remaining elements if any
	        while (i < n1) {
	            prices[k++] = leftArray[i++];
	        }

	        while (j < n2) {
	            prices[k++] = rightArray[j++];
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] bookPrices = {450, 200, 300, 150, 500, 350};

	        System.out.println("Original Book Prices:");
	        for (int price : bookPrices) {
	            System.out.print(price + " ");
	        }

	        mergeSort(bookPrices, 0, bookPrices.length - 1);

	        System.out.println("\n\nSorted Book Prices in Ascending Order:");
	        for (int price : bookPrices) {
	            System.out.print(price + " ");
	        }
	    }
	}

