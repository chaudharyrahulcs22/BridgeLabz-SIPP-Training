package oops;
	// Interface: Insurable
	interface Insurable {
	    double calculateInsurance();
	    String getInsuranceDetails();
	}

	// Abstract Class: Vehicle
	abstract class Vehicle {
	    private String vehicleNumber;
	    private String type;
	    private double rentalRate;

	    public Vehicle(String vehicleNumber, String type, double rentalRate) {
	        this.vehicleNumber = vehicleNumber;
	        this.type = type;
	        this.rentalRate = rentalRate;
	    }

	    public abstract double calculateRentalCost(int days);

	    // Getters and Setters (Encapsulation)
	    public String getVehicleNumber() { return vehicleNumber; }
	    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

	    public String getType() { return type; }
	    public void setType(String type) { this.type = type; }

	    public double getRentalRate() { return rentalRate; }
	    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

	    public void displayDetails() {
	        System.out.println("Vehicle Number: " + vehicleNumber);
	        System.out.println("Type: " + type);
	        System.out.println("Rental Rate per Day: $" + rentalRate);
	    }
	}

	// Car class
	class Car extends Vehicle implements Insurable {
	    private String insurancePolicyNumber;
	    private final double insuranceRate = 0.05; // 5% of total rental

	    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
	        super(vehicleNumber, "Car", rentalRate);
	        this.insurancePolicyNumber = insurancePolicyNumber;
	    }

	    @Override
	    public double calculateRentalCost(int days) {
	        return getRentalRate() * days;
	    }

	    @Override
	    public double calculateInsurance() {
	        return calculateRentalCost(1) * insuranceRate;
	    }

	    @Override
	    public String getInsuranceDetails() {
	        return "Car Insurance Policy #" + insurancePolicyNumber;
	    }
	}

	// Bike class
	class Bike extends Vehicle implements Insurable {
	    private String insurancePolicyNumber;
	    private final double insuranceRate = 0.02; // 2%

	    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
	        super(vehicleNumber, "Bike", rentalRate);
	        this.insurancePolicyNumber = insurancePolicyNumber;
	    }

	    @Override
	    public double calculateRentalCost(int days) {
	        return getRentalRate() * days;
	    }

	    @Override
	    public double calculateInsurance() {
	        return calculateRentalCost(1) * insuranceRate;
	    }

	    @Override
	    public String getInsuranceDetails() {
	        return "Bike Insurance Policy #" + insurancePolicyNumber;
	    }
	}

	// Truck class
	class Truck extends Vehicle implements Insurable {
	    private String insurancePolicyNumber;
	    private final double insuranceRate = 0.1; // 10%

	    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
	        super(vehicleNumber, "Truck", rentalRate);
	        this.insurancePolicyNumber = insurancePolicyNumber;
	    }

	    @Override
	    public double calculateRentalCost(int days) {
	        // Example: Trucks have a fixed surcharge
	        return (getRentalRate() * days) + 100; // $100 flat surcharge
	    }

	    @Override
	    public double calculateInsurance() {
	        return calculateRentalCost(1) * insuranceRate;
	    }

	    @Override
	    public String getInsuranceDetails() {
	        return "Truck Insurance Policy #" + insurancePolicyNumber;
	    }
	}

	// Main class
	public class vehicle_Rental_System {
	    public static void main(String[] args) {
	        Vehicle[] fleet = {
	            new Car("CAR123", 50, "CARPOL123"),
	            new Bike("BIKE456", 20, "BIKEPOL456"),
	            new Truck("TRUCK789", 100, "TRUCKPOL789")
	        };

	        int rentalDays = 5;

	        for (Vehicle v : fleet) {
	            System.out.println("\n--- Vehicle Details ---");
	            v.displayDetails();

	            double rentalCost = v.calculateRentalCost(rentalDays);
	            System.out.printf("Rental Cost for %d days: $%.2f\n", rentalDays, rentalCost);

	            if (v instanceof Insurable) {
	                Insurable ins = (Insurable) v;
	                double insurance = ins.calculateInsurance();
	                System.out.println(ins.getInsuranceDetails());
	                System.out.printf("Insurance Cost: $%.2f\n", insurance);

	                double totalCost = rentalCost + insurance;
	                System.out.printf("Total Cost (Rental + Insurance): $%.2f\n", totalCost);
	            }
	        }
	    }
	}
