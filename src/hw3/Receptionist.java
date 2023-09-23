package hw3;

public class Receptionist extends Administrator{

	private String isAnswering;
	
	public Receptionist(String name, String blazerID, String department, String isAnswering) {
		// TODO Auto-generated constructor stub
		super(name, blazerID,department);
		this.isAnswering = isAnswering;
	}
	
	public String getIsAnswering() {
		return this.isAnswering;
	}
	
	public void setIsAnswering(String isAnswering) {
		this.isAnswering = isAnswering;
	}
	
	public String toString() {
		return super.toString() + "  Answering: " + this.isAnswering;
	}

}
