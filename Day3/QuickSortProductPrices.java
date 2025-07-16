package Day3;

public class QuickSortProductPrices {

	    // Quick Sort function
	    public static void quickSort(int[] prices, int low, int high) {
	        if (low < high) {
	            // Partition the array and get the pivot index
	            int pivotIndex = partition(prices, low, high);

	            // Recursively sort elements before and after partition
	            quickSort(prices, low, pivotIndex - 1);
	            quickSort(prices, pivotIndex + 1, high);
	        }
	    }

	    // Partition function (Lomuto partition scheme)
	    public static int partition(int[] prices, int low, int high) {
	        int pivot = prices[high];  // Using last element as pivot
	        int i = low - 1;           // Index of smaller element

	        for (int j = low; j < high; j++) {
	            if (prices[j] <= pivot) {
	                i++;
	                // Swap prices[i] and prices[j]
	                int temp = prices[i];
	                prices[i] = prices[j];
	                prices[j] = temp;
	            }
	        }

	        // Swap prices[i+1] and pivot (prices[high])
	        int temp = prices[i + 1];
	        prices[i + 1] = prices[high];
	        prices[high] = temp;

	        return i + 1; // Return the pivot index
	    }

	    // Main method
	    public static void main(String[] args) {
	        int[] productPrices = {999, 199, 599, 349, 799, 149};

	        System.out.println("Original Product Prices:");
	        for (int price : productPrices) {
	            System.out.print(price + " ");
	        }

	        quickSort(productPrices, 0, productPrices.length - 1);

	        System.out.println("\n\nSorted Product Prices in Ascending Order:");
	        for (int price : productPrices) {
	            System.out.print(price + " ");
	        }
	    }
	}
