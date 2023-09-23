package hw3;

public class Nurse extends HospitalEmployee{

	private int numPatients;
	
	public Nurse(String name, String blazerID, int patients) {
		// TODO Auto-generated constructor stub
		super(name, blazerID);
		this.numPatients = patients;
	}
	
	public int getNumPatients() {
		return this.numPatients;
	}
	
	public void setNumPatients(int numPatients) {
		this.numPatients = numPatients;
	}
	
	public String toString() {
		return super.toString() + "  Number of Patients: " + this.numPatients;
	}

}
