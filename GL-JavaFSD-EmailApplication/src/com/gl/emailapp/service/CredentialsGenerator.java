package com.gl.emailapp.service;

import com.gl.emailapp.Employee;

public class CredentialsGenerator {
	
	private String generatedEmailID;
	public Employee employee;
	
	public CredentialsGenerator(Employee employee) {
		this.employee = employee;
	}

	public void generateEmailID() {
		
		String departmentShortName = getDepartmentShortName();
		
		String emailID = employee.getFirstName().toLowerCase()
				+"."+ employee.getLastName().toLowerCase()
				+"@"+ departmentShortName+".gl.com";
		
		employee.setEmailID(emailID);
		
		//this.generatedEmailID = emailID;
	}


	private String getDepartmentShortName() {
		String departmentName = employee.getDepartment();
		
		if (departmentName.equals("Technical")) {
			return "tech";
		} else if (departmentName.equals("Admin")) {
			return "adm";
		} else if (departmentName.equals("Human Resources")) {
			return "hr";
		} else if (departmentName.equals("Legal")) {
			return "lgl";
		}
		return "";
	}
	
	public void displayCredentials() {
		System.out.println("Hi "+ employee.getFirstName() + ", your generated credentials are as follows :: ");
		System.out.println("Name	: "+ employee.getFirstName()+" "+employee.getLastName());
		System.out.println("Email ID: "+generatedEmailID);
		System.out.println("Password: ");
	}
	
	
}
