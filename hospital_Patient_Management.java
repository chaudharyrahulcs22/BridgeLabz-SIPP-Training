package oops;
	import java.util.ArrayList;
	import java.util.List;

	// Interface: MedicalRecord
	interface MedicalRecord {
	    void addRecord(String record);
	    List<String> viewRecords();
	}

	// Abstract Class: Patient
	abstract class Patient {
	    private int patientId;
	    private String name;
	    private int age;

	    // Encapsulated sensitive data
	    private String diagnosis;
	    private List<String> medicalHistory = new ArrayList<>();

	    public Patient(int patientId, String name, int age, String diagnosis) {
	        this.patientId = patientId;
	        this.name = name;
	        this.age = age;
	        this.diagnosis = diagnosis;
	    }

	    // Abstract method
	    public abstract double calculateBill();

	    // Concrete method
	    public void getPatientDetails() {
	        System.out.println("Patient ID: " + patientId);
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Diagnosis: " + diagnosis);
	    }

	    // Encapsulation: no public setter for diagnosis
	    protected void addToMedicalHistory(String record) {
	        medicalHistory.add(record);
	    }

	    protected List<String> getMedicalHistory() {
	        return new ArrayList<>(medicalHistory);
	    }

	    protected String getDiagnosis() {
	        return diagnosis;
	    }
	}

	// InPatient class
	class InPatient extends Patient implements MedicalRecord {
	    private int daysAdmitted;
	    private double roomRatePerDay;
	    private double treatmentCharges;

	    public InPatient(int patientId, String name, int age, String diagnosis, int daysAdmitted, double roomRatePerDay, double treatmentCharges) {
	        super(patientId, name, age, diagnosis);
	        this.daysAdmitted = daysAdmitted;
	        this.roomRatePerDay = roomRatePerDay;
	        this.treatmentCharges = treatmentCharges;
	    }

	    @Override
	    public double calculateBill() {
	        return (daysAdmitted * roomRatePerDay) + treatmentCharges;
	    }

	    @Override
	    public void addRecord(String record) {
	        addToMedicalHistory("InPatient: " + record);
	    }

	    @Override
	    public List<String> viewRecords() {
	        return getMedicalHistory();
	    }
	}

	// OutPatient class
	class OutPatient extends Patient implements MedicalRecord {
	    private double consultationFee;
	    private double testCharges;

	    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee, double testCharges) {
	        super(patientId, name, age, diagnosis);
	        this.consultationFee = consultationFee;
	        this.testCharges = testCharges;
	    }

	    @Override
	    public double calculateBill() {
	        return consultationFee + testCharges;
	    }

	    @Override
	    public void addRecord(String record) {
	        addToMedicalHistory("OutPatient: " + record);
	    }

	    @Override
	    public List<String> viewRecords() {
	        return getMedicalHistory();
	    }
	}

	// Main Class
	public class hospital_Patient_Management {
	    public static void main(String[] args) {
	        Patient[] patients = new Patient[] {
	            new InPatient(101, "Alice", 30, "Appendicitis", 5, 1500, 3000),
	            new OutPatient(102, "Bob", 45, "Flu", 500, 200)
	        };

	        // Add medical records using interface
	        for (Patient p : patients) {
	            if (p instanceof MedicalRecord m) {
	                m.addRecord("Initial checkup");
	                m.addRecord("Prescribed medications");
	            }
	        }

	        // Polymorphic processing
	        for (Patient p : patients) {
	            System.out.println("\n--- Patient Details ---");
	            p.getPatientDetails();
	            System.out.printf("Total Bill: $%.2f\n", p.calculateBill());

	            if (p instanceof MedicalRecord m) {
	                System.out.println("Medical Records:");
	                for (String record : m.viewRecords()) {
	                    System.out.println(" - " + record);
	                }
	            }
	        }
	    }
	}
