package hw3;

public class Surgeon extends Doctor{
	
	private String isOperating;
	
	public Surgeon(String name, String blazerID, String specialty, String isOperating) {
		// TODO Auto-generated constructor stub
		super(name, blazerID, specialty);
		this.isOperating = isOperating;
	}
	
	public String getIsOperating() {
		return this.isOperating;
	}
	
	public void setIsOperating(String isOperating) {
		this.isOperating = isOperating;
	}
	
	public String toString() {
		return super.toString() + "  Operating: " + this.isOperating;
	}

}
