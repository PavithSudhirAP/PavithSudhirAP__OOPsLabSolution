package com.gl.emailapp.service;

import java.util.Random;

import com.gl.emailapp.Employee;

public class CredentialsGenerator {
	
	private String generatedEmailID;
	private char[] generatedPassword = new char[8];
	public Employee employee;
	
	public CredentialsGenerator(Employee employee) {
		this.employee = employee;
	}

	public void generateEmailID() {
		
		String departmentShortName = getDepartmentShortName();
		
		String emailID = employee.getFirstName().toLowerCase()
				+ employee.getLastName().toLowerCase()
				+"@"+ departmentShortName+".gl.com";
		
		this.generatedEmailID = emailID;
	}

	public void generatePassword() {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String spclChars = "!@#$%^&*_=+-/.?<>";
		String nums = "1234567890";
		
		String allItems = upperCase+lowerCase+spclChars+nums;
		
		Random rdmObj = new Random();
		
		for(int i = 0; i < 8; i++) {
			int randomIndex = rdmObj.nextInt(allItems.length());
			char randomChar = allItems.charAt(randomIndex);
			this.generatedPassword[i] = randomChar;
		}
	}

	private String getDepartmentShortName() {
		String departmentName = employee.getDepartment();
		
		if (departmentName.equals("Technical")) {
			return "tech";
		} else if (departmentName.equals("Admin")) {
			return "adm";
		} else if (departmentName.equals("Human Resource")) {
			return "hr";
		} else if (departmentName.equals("Legal")) {
			return "lgl";
		}
		return "";
	}
	
	public void displayCredentials() {
		System.out.println("\nHi "+ employee.getFirstName() + ", your credentials are given below:: ");
		System.out.println("------------------------------------------------------");
		System.out.println("Name	: "+ employee.getFirstName()+" "+employee.getLastName());
		System.out.println("Email ID: "+generatedEmailID);
		System.out.print("Password: ");
		System.out.println(generatedPassword);
		System.out.println("------------------------------------------------------");
		
	}
	
}
