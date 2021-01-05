package com.capgemini.view;
import java.util.Scanner;

import com.capgemini.service.StudentSchedular;

public class Admin {

	private static Scanner sc= new Scanner(System.in);	

	
	private static StudentSchedular stc=new StudentSchedular(); 
	public static void main(String[] args) {
		
		Menu();

	}
	
	private static void Menu() {
		
		while(true)
		{
			System.out.println("1. Add Student");
			System.out.println("2. Show All students");
			System.out.println("3. Show student details by roll number");
			System.out.println("4. Show student details by course name");
			System.out.println("5. Show student count by course name");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				add_details();
				break;
			case 2:
				showAllDetails();
				break;
			case 3:
				studentbyrollnumber();
				break;
			case 4:
				studentbycoursename();
				break;
			case 5:
				studentcountbycourse();
				break;
			case 6:
				System.exit(choice);
				break;
			default:
				System.out.println("Sorry entered wrong option");
			}
			
		}
				
		
	}

	private static void studentcountbycourse() {
		
		System.out.println("Enter your course name:");
		String coursename=sc.next();		
		stc.studentcountbycourse(coursename);
		
	}

	private static void studentbycoursename() {
		
		System.out.println("Enter course name:");
		String coursestudent=sc.next();
		stc.studentbycoursename(coursestudent);
		
	}

	private static void studentbyrollnumber() {
		
		System.out.println("Enter your roll no:");
		int roll=sc.nextInt();		
		stc.studentbyrollnumber(roll);
		
	}

	private static void showAllDetails() {
		stc.showAllDetails();
		
	}

	private static void add_details() {
		
		//for(int i=0;i<10;i++) {
		if (true) {
		
		System.out.println("Enter roll number:");
		int rollNumber=sc.nextInt();
		
		System.out.println("Enter your name:");
		String name=sc.next();
		
		System.out.println("How many courses do you want:");
		int number=sc.nextInt();
		
		String[] courses=new String[number];
		System.out.println("Enter the name of the courses:");
		
		for (int j=0;j<number;j++)
		{
			courses[j]=sc.next();
		}
		
		System.out.println(stc.enterdetails(rollNumber, name, courses));
		
		
		}
	}

}
