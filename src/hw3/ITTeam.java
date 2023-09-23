package hw3;

public class ITTeam extends HospitalEmployee{

	private String team;
	
	public ITTeam(String name, String blazerID, String team) {
		// TODO Auto-generated constructor stub
		super(name, blazerID);
		this.team = team;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String toString() {
		return super.toString() + "  Team: " + this.team;
	}

}
