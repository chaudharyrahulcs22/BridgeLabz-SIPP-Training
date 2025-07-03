package oops;
	// Interface: Discountable
	interface Discountable {
	    double applyDiscount();
	    String getDiscountDetails();
	}

	// Abstract Class: FoodItem
	abstract class FoodItem {
	    private String itemName;
	    private double price;
	    private int quantity;

	    public FoodItem(String itemName, double price, int quantity) {
	        this.itemName = itemName;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    // Abstract method
	    public abstract double calculateTotalPrice();

	    // Concrete method
	    public void getItemDetails() {
	        System.out.println("Item: " + itemName);
	        System.out.println("Unit Price: $" + price);
	        System.out.println("Quantity: " + quantity);
	    }

	    // Encapsulation (Getters, no public setters for price/quantity)
	    public String getItemName() { return itemName; }
	    public double getPrice() { return price; }
	    public int getQuantity() { return quantity; }

	    protected void setPrice(double price) { this.price = price; }
	    protected void setQuantity(int quantity) { this.quantity = quantity; }
	}

	// VegItem class
	class VegItem extends FoodItem implements Discountable {
	    private final double discountRate = 0.1; // 10%

	    public VegItem(String itemName, double price, int quantity) {
	        super(itemName, price, quantity);
	    }

	    @Override
	    public double calculateTotalPrice() {
	        return getPrice() * getQuantity();
	    }

	    @Override
	    public double applyDiscount() {
	        return calculateTotalPrice() * discountRate;
	    }

	    @Override
	    public String getDiscountDetails() {
	        return "10% Veg Discount";
	    }
	}

	// NonVegItem class
	class NonVegItem extends FoodItem implements Discountable {
	    private final double discountRate = 0.05; // 5%
	    private final double nonVegCharge = 2.0; // extra charge per item

	    public NonVegItem(String itemName, double price, int quantity) {
	        super(itemName, price, quantity);
	    }

	    @Override
	    public double calculateTotalPrice() {
	        return (getPrice() + nonVegCharge) * getQuantity();
	    }

	    @Override
	    public double applyDiscount() {
	        return calculateTotalPrice() * discountRate;
	    }

	    @Override
	    public String getDiscountDetails() {
	        return "5% Non-Veg Discount (includes $2/item charge)";
	    }
	}

	// Main Class
	public class online_Food_Delivery {
	    public static void main(String[] args) {
	        FoodItem[] orderItems = {
	            new VegItem("Paneer Tikka", 8.0, 2),
	            new NonVegItem("Chicken Biryani", 12.0, 1),
	            new VegItem("Veg Burger", 6.5, 3),
	            new NonVegItem("Fish Curry", 10.0, 2)
	        };

	        processOrder(orderItems);
	    }

	    // Polymorphic order processing method
	    public static void processOrder(FoodItem[] items) {
	        double grandTotal = 0.0;

	        for (FoodItem item : items) {
	            System.out.println("\n--- Item Details ---");
	            item.getItemDetails();

	            double totalPrice = item.calculateTotalPrice();
	            System.out.printf("Total Price Before Discount: $%.2f\n", totalPrice);

	            if (item instanceof Discountable d) {
	                double discount = d.applyDiscount();
	                System.out.println(d.getDiscountDetails());
	                System.out.printf("Discount: -$%.2f\n", discount);
	                totalPrice -= discount;
	            }

	            System.out.printf("Final Price: $%.2f\n", totalPrice);
	            grandTotal += totalPrice;
	        }

	        System.out.printf("\n>>> Grand Total for Order: $%.2f\n", grandTotal);
	    }
	}
