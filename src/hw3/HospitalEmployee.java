package hw3;

public class HospitalEmployee {
	private String name, blazerID;
	
	public HospitalEmployee(String name, String blazerID) {
		this.name = name;
		this.blazerID = blazerID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getID() {
		return this.blazerID;
	}
	
	public void setID(String blazerID) {
		this.blazerID = blazerID;
	}
	
	public String toString() {
		return "Name: " + this.name + "  Blazer ID: " + this.blazerID;
	}
		
}
