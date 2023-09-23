package hw3;

public class Doctor extends HospitalEmployee{
	
	private String specialty;
	
	public Doctor(String name, String blazerID, String specialty) {
		// TODO Auto-generated constructor stub
		super(name, blazerID);
		this.specialty = specialty;
	}
	
	public String getSpecialty() {
		return this.specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public String toString() {
		return super.toString() + "  Speciality: " + this.specialty;
	}

}
