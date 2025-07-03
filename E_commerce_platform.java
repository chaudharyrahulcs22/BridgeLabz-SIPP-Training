package oops;
	// Interface: Taxable
	interface Taxable {
	    double calculateTax();
	    String getTaxDetails();
	}

	// Abstract Class: Product
	abstract class Product {
	    private int productId;
	    private String name;
	    private double price;

	    public Product(int productId, String name, double price) {
	        this.productId = productId;
	        this.name = name;
	        this.price = price;
	    }

	    // Abstract method
	    public abstract double calculateDiscount();

	    // Getters and Setters (Encapsulation)
	    public int getProductId() { return productId; }
	    public void setProductId(int productId) { this.productId = productId; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public double getPrice() { return price; }
	    public void setPrice(double price) { this.price = price; }

	    public void displayDetails() {
	        System.out.println("Product ID: " + productId);
	        System.out.println("Name: " + name);
	        System.out.println("Base Price: $" + price);
	    }
	}

	// Electronics class (Taxable)
	class Electronics extends Product implements Taxable {
	    private final double discountRate = 0.10; // 10%
	    private final double taxRate = 0.18; // 18%

	    public Electronics(int productId, String name, double price) {
	        super(productId, name, price);
	    }

	    @Override
	    public double calculateDiscount() {
	        return getPrice() * discountRate;
	    }

	    @Override
	    public double calculateTax() {
	        return getPrice() * taxRate;
	    }

	    @Override
	    public String getTaxDetails() {
	        return "Electronics Tax (18%)";
	    }
	}

	// Clothing class (Taxable)
	class Clothing extends Product implements Taxable {
	    private final double discountRate = 0.15; // 15%
	    private final double taxRate = 0.12; // 12%

	    public Clothing(int productId, String name, double price) {
	        super(productId, name, price);
	    }

	    @Override
	    public double calculateDiscount() {
	        return getPrice() * discountRate;
	    }

	    @Override
	    public double calculateTax() {
	        return getPrice() * taxRate;
	    }

	    @Override
	    public String getTaxDetails() {
	        return "Clothing Tax (12%)";
	    }
	}

	// Groceries class (Non-taxable, low discount)
	class Groceries extends Product {
	    private final double discountRate = 0.05; // 5%

	    public Groceries(int productId, String name, double price) {
	        super(productId, name, price);
	    }

	    @Override
	    public double calculateDiscount() {
	        return getPrice() * discountRate;
	    }
	}

	// Main class
	public class E_commerce_platform {
	    public static void main(String[] args) {
	        Product[] products = new Product[] {
	            new Electronics(1, "Laptop", 1000),
	            new Clothing(2, "Jeans", 80),
	            new Groceries(3, "Rice", 40)
	        };

	        for (Product p : products) {
	            System.out.println("\n--- Product Details ---");
	            p.displayDetails();

	            double discount = p.calculateDiscount();
	            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
	            double finalPrice = p.getPrice() + tax - discount;

	            System.out.printf("Discount: $%.2f\n", discount);
	            if (p instanceof Taxable) {
	                System.out.printf("%s: $%.2f\n", ((Taxable) p).getTaxDetails(), tax);
	            } else {
	                System.out.println("No tax applicable.");
	            }
	            System.out.printf("Final Price: $%.2f\n", finalPrice);
	        }
	    }
	}
