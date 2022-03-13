package com.gl.emailapp.ui;

import java.util.Scanner;

import com.gl.emailapp.Employee;
import com.gl.emailapp.service.CredentialsGenerator;

public class EmailAppUI {
	
	public void initiate() {
		Employee employee = displayUI();
		callService(employee);
	}
	
	private Employee displayUI() {
		
		displayWelcome();		
		Employee employee =	fetchEmployeeDetails();		
		return employee;
	}
	
	private void displayWelcome() {

		System.out.println("************************************************");
		System.out.println("****Welcome-to-GL-Employee-Email-Application****");
		System.out.println("************************************************\n");
				
	}
	
	private Employee fetchEmployeeDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee's first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter employee's last name: ");
		String lastName = sc.nextLine();
				
		System.out.println("Choose Employee's department: ");
		
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		System.out.println("Select 1/2/3/4 for employee's department");
		
		int deptID = sc.nextInt();
		String departmentName = getDepartmentName(deptID);
		
		Employee employee = new Employee(firstName, lastName, departmentName);
		
		sc.close();
		
		return employee;
	}

	private String getDepartmentName(int deptID) {
		if (deptID == 1) {
			return "Technical";
		}else if (deptID == 2) {
			return "Admin";
		}else if (deptID == 3) {
			return "Human Resource";
		}else if (deptID == 4) {
			return "Legal";
		}else {
			return "";
		}
	}
	
	private void callService(Employee employee) {
		
		CredentialsGenerator credGenerator = new CredentialsGenerator(employee);
		
		credGenerator.generateEmailID();
		credGenerator.generatePassword();
		
		credGenerator.displayCredentials();
		
	}
	
}
