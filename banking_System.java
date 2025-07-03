package oops;
	// Interface: Loanable
	interface Loanable {
	    void applyForLoan(double amount);
	    double calculateLoanEligibility();
	}

	// Abstract Class: BankAccount
	abstract class BankAccount {
	    private String accountNumber;
	    private String holderName;
	    private double balance;

	    public BankAccount(String accountNumber, String holderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.holderName = holderName;
	        this.balance = balance;
	    }

	    // Abstract method
	    public abstract double calculateInterest();

	    // Concrete methods
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.printf("$%.2f deposited. New balance: $%.2f\n", amount, balance);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && balance >= amount) {
	            balance -= amount;
	            System.out.printf("$%.2f withdrawn. New balance: $%.2f\n", amount, balance);
	        } else {
	            System.out.println("Insufficient balance or invalid amount.");
	        }
	    }

	    // Encapsulation
	    public String getAccountNumber() { return accountNumber; }
	    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

	    public String getHolderName() { return holderName; }
	    public void setHolderName(String holderName) { this.holderName = holderName; }

	    public double getBalance() { return balance; }
	    public void setBalance(double balance) { this.balance = balance; }

	    public void displayDetails() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Holder Name: " + holderName);
	        System.out.printf("Balance: $%.2f\n", balance);
	    }
	}

	// SavingsAccount Class
	class SavingsAccount extends BankAccount implements Loanable {
	    private final double interestRate = 0.04; // 4%

	    public SavingsAccount(String accountNumber, String holderName, double balance) {
	        super(accountNumber, holderName, balance);
	    }

	    @Override
	    public double calculateInterest() {
	        return getBalance() * interestRate;
	    }

	    @Override
	    public void applyForLoan(double amount) {
	        System.out.printf("Loan application submitted for $%.2f from Savings Account.\n", amount);
	    }

	    @Override
	    public double calculateLoanEligibility() {
	        return getBalance() * 2; // Eligible for up to 2x balance
	    }
	}

	// CurrentAccount Class
	class CurrentAccount extends BankAccount implements Loanable {
	    private final double interestRate = 0.01; // 1%

	    public CurrentAccount(String accountNumber, String holderName, double balance) {
	        super(accountNumber, holderName, balance);
	    }

	    @Override
	    public double calculateInterest() {
	        return getBalance() * interestRate;
	    }

	    @Override
	    public void applyForLoan(double amount) {
	        System.out.printf("Loan application submitted for $%.2f from Current Account.\n", amount);
	    }

	    @Override
	    public double calculateLoanEligibility() {
	        return getBalance() * 1.5; // Eligible for up to 1.5x balance
	    }
	}

	// Main Class
	public class banking_System {
	    public static void main(String[] args) {
	        BankAccount[] accounts = {
	            new SavingsAccount("SA101", "Alice", 5000),
	            new CurrentAccount("CA202", "Bob", 10000)
	        };

	        for (BankAccount acc : accounts) {
	            System.out.println("\n--- Account Details ---");
	            acc.displayDetails();

	            double interest = acc.calculateInterest();
	            System.out.printf("Calculated Interest: $%.2f\n", interest);

	            acc.deposit(1000);
	            acc.withdraw(700);

	            if (acc instanceof Loanable loanAcc) {
	                loanAcc.applyForLoan(3000);
	                System.out.printf("Loan Eligibility: $%.2f\n", loanAcc.calculateLoanEligibility());
	            }
	        }
	    }
	}
