package hw3;

public class Janitor extends Administrator{

	private String isSweeping;
	
	public Janitor(String name, String blazerID, String department, String isSweeping) {
		// TODO Auto-generated constructor stub
		super(name, blazerID,department);
		this.isSweeping = isSweeping;
	}
	
	public String getIsSweeping() {
		return this.isSweeping;
	}
	
	public void setIsSweeping(String isSweeping) {
		this.isSweeping = isSweeping;
	}
	
	public String toString() {
		return super.toString() + "  Sweeping: " + this.isSweeping;
	}

}
