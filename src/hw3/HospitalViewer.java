package hw3;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class HospitalViewer {
	
	private static ArrayList<HospitalEmployee> employees = new ArrayList<HospitalEmployee>();
	 
	public static void main(String[] args) {
	
		int countTotal = 0;
		int countE = 0;
		int countD = 0;
		int countN = 0;
		int countA = 0; 
		int countR = 0;
		int countJ = 0;
		int countS = 0;
		int countI = 0;
		
		//Scans the text file
		try(Scanner fileScan = new Scanner(new File("uabEmployee.txt"))){

			while(fileScan.hasNextLine()) {

				String line = fileScan.nextLine();
				String job = String.valueOf(line.charAt(0));
				
				//Can stay outside of the different If Statements because
				//these variables are in ALL of the different objects, so there
				//is no need to have this in every if statement.
				String name = "";
				String id= "";
				
				//Getting the Name and Blazer ID
				//end is the index of the start of the name after the first character which identifies the person's role
				int end = 2;
				for(int i = 2; i < line.length(); i++) {
					char c = line.charAt(i);
					//once we are at a whitespace, we will break out of this loop, meaning we have the name
					if(Character.isWhitespace(c)) {
						break;
					} else {
						name += c;
					}
					//new starting point
					end = i;
				}	
				//end+2 because that is the start of the blazerID
				for(int i = end+2; i < line.length(); i++) {
					char c = line.charAt(i);
					if(Character.isWhitespace(c)) {
						break;
					} else {
						id += c;
					}
					//new starting point for jobs that may have more variables
					end = i;
				}

				//Adding Employees based on the first character on each line.
				//adds count while making employees.
				if(job.equals("E")) {
					HospitalEmployee e = new HospitalEmployee(name, id);
					employees.add(e);
					countE++;
				}
				
				else if(job.equals("D")) {
					String spec = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							spec += c;
						}
						end = i;
					}
					
					HospitalEmployee d = new Doctor(name, id, spec);
					employees.add(d);
					countD++;
				}
				
				else if(job.equals("N")) {
					int num;
					String temp = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							temp += c;
						}
					}
					num = Integer.parseInt(temp);
					
					HospitalEmployee n = new Nurse(name, id, num);
					employees.add(n);
					countN++;
				}
				
				else if(job.equals("A")) {
					String dept = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							dept += c;
						}
					}
					
					HospitalEmployee a = new Administrator(name, id, dept);
					employees.add(a);
					countA++;
				}
				
				else if(job.equals("R")) {
					String dept = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							dept += c;
						}
						end = i;
					}
					String yesOrNo = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							yesOrNo += c;
						}
					}
					
					HospitalEmployee r = new Receptionist(name, id, dept, yesOrNo);
					employees.add(r);
					countR++;
				}
				
				else if(job.equals("J")) {
					String dept = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							dept += c;
						}
						end = i;
					}
					String yesOrNo = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							yesOrNo += c;
						}
					}
					
					HospitalEmployee j = new Janitor(name, id, dept, yesOrNo);
					employees.add(j);
					countJ++;
				}
				
				else if(job.equals("S")) {
					String dept = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							dept += c;
						}
						end = i;
					}
					String yesOrNo = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							yesOrNo += c;
						}
					}
					
					HospitalEmployee s = new Surgeon(name, id, dept, yesOrNo);
					employees.add(s);
					countS++;
				}
				
				else if(job.equals("I")) {
					String dept = "";
					for(int i = end+2; i < line.length(); i++) {
						char c = line.charAt(i);
						if(Character.isWhitespace(c)) {
							break;
						} else {
							dept += c;
						}
					}
					
					HospitalEmployee i = new ITTeam(name, id, dept);
					employees.add(i);
					countI++;
				}
				
				countTotal++;
				
			}
			fileScan.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.toString());
		}
		
		
		
		//====================================================INTERFACE==================================================================
		//===============================================================================================================================
		boolean done = false;  //set false so the while loop can keep going
		System.out.println("===================================================================================");	
		System.out.println("Welcome to the UAB Employees System");
		System.out.println("===================================================================================");
		
		//This loop will continue until user decides that they are done
		while(!done) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println(" ");
			System.out.println("Enter your choice:");
			System.out.println("***********************************************************************************");
			System.out.println("Display Employees(1)");
			System.out.println("Add employee(2)");
			System.out.println("Delete Employee(3)");
			System.out.println("Exit(4)");
			System.out.println("***********************************************************************************");
			
			String input = scan.nextLine();
			int user = Integer.parseInt(input);
			
			//breaks out of the loop
			if(user == 4) {
				scan.close();
				System.out.println("Goodbye!");
				done = true;
			}
			
			//displays employees
			else if(user == 1) {
				
				System.out.println("The UAB Hospital has the following: ");
				System.out.println(" ");
				
				System.out.println("Number of Employees: " + countTotal);  //first display total count of employees
				System.out.println(" ");
				
				//Now prints each type of employee
				System.out.println("Hospital Employees: " + countE);
				for(HospitalEmployee e: employees) {
					if(e.getClass().equals(HospitalEmployee.class)) {
						System.out.println(e.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Doctors: " + countD);
				for(HospitalEmployee d: employees) {
					if(d.getClass().equals(Doctor.class)) {
						System.out.println(d.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Surgeons: " + countS);
				for(HospitalEmployee s : employees) {
					if(s.getClass().equals(Surgeon.class)) {
						System.out.println(s.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Nurses: " + countN);
				for(HospitalEmployee n : employees) {
					if(n.getClass().equals(Nurse.class)) {
						System.out.println(n.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Administrstors: " + countA);
				for(HospitalEmployee a : employees) {
					if(a.getClass().equals(Administrator.class)) {
						System.out.println(a.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Receptionists: " + countR);
				for(HospitalEmployee r : employees) {
					if(r.getClass().equals(Receptionist.class)) {
						System.out.println(r.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("Janitors: " + countJ);
				for(HospitalEmployee j : employees) {
					if(j.getClass().equals(Janitor.class)) {
						System.out.println(j.toString());
					}
				}
				System.out.println(" ");
				
				System.out.println("IT Team: " + countI);
				for(HospitalEmployee i : employees) {
					if(i.getClass().equals(ITTeam.class)) {
						System.out.println(i.toString());
					}
				}
			}
			
			//adds an employee
			else if(user == 2) {
				//First choose what type of employee
				System.out.println("Enter what type of Employee you want to add: ");
				System.out.println("Hospital Employee (1)");
				System.out.println("Doctor (2)");
				System.out.println("Surgeon (3)");
				System.out.println("Nurse (4)");
				System.out.println("Administrator (5)");
				System.out.println("Receptionist (6)");
				System.out.println("Janitor (7)");
				System.out.println("IT Team (8)");
				
				String input2 = scan.nextLine();
				int job = Integer.parseInt(input2);
					
				System.out.println("Enter the employee's first name: "); //name
				String name = scan.nextLine();
				
				System.out.println("Enter the employee's Blazer ID: "); //id
				String id = scan.nextLine();
				
				//Adds each employee while updating the list counts
				if(job == 1) {
					HospitalEmployee newbie = new HospitalEmployee(name, id);
					employees.add(newbie);
					countE++;
				}
				
				//more inputs if if th class demands it
				else if(job == 2) {
					System.out.println("What is their specialty?: ");
					String specialty = scan.nextLine();
					
					HospitalEmployee newbie = new Doctor(name, id, specialty);
					employees.add(newbie);
					countD++;
				}
				
				else if(job == 3) {
					System.out.println("What is their specialty?: ");
					String specialty = scan.nextLine();
					
					System.out.println("Are they Operating? (Y/N)");
					String operating = scan.nextLine();
					
					HospitalEmployee newbie = new Surgeon(name, id, specialty, operating);
					employees.add(newbie);
					countS++;
				}
				
				else if(job == 4) {
					System.out.println("How many patients do they have?: ");
					String input3 = scan.nextLine();
					int patients = Integer.parseInt(input3);
					
					HospitalEmployee newbie = new Nurse(name, id, patients);
					employees.add(newbie);
					countS++;
				}
				
				else if(job == 5) {
					System.out.println("What is their department?: ");
					String department = scan.nextLine();
					
					HospitalEmployee newbie = new Administrator(name, id, department);
					employees.add(newbie);
					countA++;
				}
				
				else if(job == 6){
					System.out.println("What is their department?: ");
					String department = scan.nextLine();
					
					System.out.println("Are they talking? (Y/N)");
					String talking = scan.nextLine();
					
					HospitalEmployee newbie = new Receptionist(name, id, department, talking);
					employees.add(newbie);
					countR++;
				}
				
				else if(job == 7) {
					System.out.println("What is their department?: ");
					String department = scan.nextLine();
					 
					System.out.println("Are they Sweeping? (Y/N)");
					String sweeping = scan.nextLine();
					
					HospitalEmployee newbie = new Janitor(name, id, department, sweeping);
					employees.add(newbie);
					countJ++;
				}
				
				else if(job == 8) {
					System.out.println("What is their team?: ");
					String team = scan.nextLine();
					
					HospitalEmployee newbie = new ITTeam(name, id, team);
					employees.add(newbie);
					countI++;
				}
				countTotal++;
			}
			
			//deletes an employee
			else if(user == 3) {
				
				//Input for ID
				System.out.println("Enter the Blazer ID of the employee you want to delete: ");
				String id = scan.nextLine();
				
				for(int i = 0; i < employees.size(); i++) {
					//checks if current element's ID in array is equal to the input
					if(employees.get(i).getID().equals(id)) {
						
						//updates the list counts
						if(employees.get(i).getClass().equals(HospitalEmployee.class)) { countE--; }
						else if(employees.get(i).getClass().equals(Doctor.class)) { countD--; }
						else if(employees.get(i).getClass().equals(Surgeon.class)) { countS--; }
						else if(employees.get(i).getClass().equals(Nurse.class)) { countN--; }
						else if(employees.get(i).getClass().equals(Administrator.class)) { countA--; }
						else if(employees.get(i).getClass().equals(Receptionist.class)) { countR--; }
						else if(employees.get(i).getClass().equals(Janitor.class)) { countJ--; }
						else if(employees.get(i).getClass().equals(ITTeam.class)) { countI--; }
						countTotal--;
						
						//deleting/firing employee from list
						System.out.println("Firing " + employees.get(i).getName() + "...");
						employees.remove(employees.get(i));	
					}
				}
			}
		}
	}
		
}