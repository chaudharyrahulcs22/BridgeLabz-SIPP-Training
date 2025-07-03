package oops;
	// Interface: Reservable
	interface Reservable {
	    boolean reserveItem(String borrowerName);
	    boolean checkAvailability();
	}

	// Abstract Class: LibraryItem
	abstract class LibraryItem {
	    private String itemId;
	    private String title;
	    private String author;

	    // Sensitive borrower data (Encapsulation)
	    private String reservedBy;

	    public LibraryItem(String itemId, String title, String author) {
	        this.itemId = itemId;
	        this.title = title;
	        this.author = author;
	        this.reservedBy = null; // Initially not reserved
	    }

	    // Abstract method
	    public abstract int getLoanDuration(); // in days

	    // Concrete method
	    public void getItemDetails() {
	        System.out.println("ID: " + itemId);
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	    }

	    // Encapsulated getter (no setter for security)
	    protected String getReservedBy() {
	        return reservedBy;
	    }

	    protected void setReservedBy(String reservedBy) {
	        this.reservedBy = reservedBy;
	    }

	    public boolean isReserved() {
	        return reservedBy != null;
	    }
	}

	// Book class
	class Book extends LibraryItem implements Reservable {
	    public Book(String itemId, String title, String author) {
	        super(itemId, title, author);
	    }

	    @Override
	    public int getLoanDuration() {
	        return 21; // 3 weeks
	    }

	    @Override
	    public boolean reserveItem(String borrowerName) {
	        if (!isReserved()) {
	            setReservedBy(borrowerName);
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public boolean checkAvailability() {
	        return !isReserved();
	    }
	}

	// Magazine class
	class Magazine extends LibraryItem implements Reservable {
	    public Magazine(String itemId, String title, String author) {
	        super(itemId, title, author);
	    }

	    @Override
	    public int getLoanDuration() {
	        return 7; // 1 week
	    }

	    @Override
	    public boolean reserveItem(String borrowerName) {
	        if (!isReserved()) {
	            setReservedBy(borrowerName);
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public boolean checkAvailability() {
	        return !isReserved();
	    }
	}

	// DVD class
	class DVD extends LibraryItem implements Reservable {
	    public DVD(String itemId, String title, String author) {
	        super(itemId, title, author);
	    }

	    @Override
	    public int getLoanDuration() {
	        return 14; // 2 weeks
	    }

	    @Override
	    public boolean reserveItem(String borrowerName) {
	        if (!isReserved()) {
	            setReservedBy(borrowerName);
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public boolean checkAvailability() {
	        return !isReserved();
	    }
	}

	// Main class
	public class library_Management {
	    public static void main(String[] args) {
	        LibraryItem[] items = {
	            new Book("B001", "The Hobbit", "J.R.R. Tolkien"),
	            new Magazine("M001", "Time Magazine", "Various"),
	            new DVD("D001", "Inception", "Christopher Nolan")
	        };

	        String borrower = "John Doe";

	        for (LibraryItem item : items) {
	            System.out.println("\n--- Item Details ---");
	            item.getItemDetails();
	            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

	            if (item instanceof Reservable reservable) {
	                System.out.println("Available: " + (reservable.checkAvailability() ? "Yes" : "No"));
	                if (reservable.reserveItem(borrower)) {
	                    System.out.println("Item successfully reserved for: " + borrower);
	                } else {
	                    System.out.println("Item is already reserved.");
	                }
	            }
	        }
	    }
	}
