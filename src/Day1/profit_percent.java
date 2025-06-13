package Day1;

public class profit_percent {

	public static void main(String[] args) {
		int cost_price = 129;
		int selling_price = 191;
		int profit = selling_price - cost_price;
		double profit_Percentage = ((double)profit/cost_price)* 100;
		System.out.print("The cost price is INR " + cost_price + " and selling price is INR " + selling_price +
				"The profit is INR "+ profit + "and the profit percentage is " + profit_Percentage);
	}

}
