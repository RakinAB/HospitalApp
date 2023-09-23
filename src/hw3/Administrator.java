package hw3;

public class Administrator extends HospitalEmployee{
	
	private String department;
	
	public Administrator(String name, String blazerID, String department) {
		// TODO Auto-generated constructor stub
		super(name, blazerID);
		this.department = department;
	}

	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return super.toString() + "  Department: " + this.department;
	}
}
