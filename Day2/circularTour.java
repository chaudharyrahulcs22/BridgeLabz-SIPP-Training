package Day2;

public class circularTour {

// Returns starting pump index if possible, otherwise -1
	 public static int findStartPoint(int[] petrol, int[] distance) {
	        int n = petrol.length;
	        int start = 0;
	        int surplus = 0;     // current fuel in the tank
	        int deficit = 0;     // fuel shortfall when the tour failed

	        for (int i = 0; i < n; i++) {
	            surplus += petrol[i] - distance[i];

	            if (surplus < 0) {
	                // Can't reach next station, reset start point
	                start = i + 1;
	                deficit += surplus; // accumulate deficit
	                surplus = 0;
	            }
	        }

	        // If total petrol is enough, return start index
	        return (surplus + deficit >= 0) ? start : -1;
	    }

	    public static void main(String[] args) {
	        int[] petrol = {4, 6, 7, 4};
	        int[] distance = {6, 5, 3, 5};

	        int start = findStartPoint(petrol, distance);

	        if (start != -1) {
	            System.out.println("Start the tour from pump: " + start);
	        } else {
	            System.out.println("No feasible tour possible");
	        }
	    }
	}
