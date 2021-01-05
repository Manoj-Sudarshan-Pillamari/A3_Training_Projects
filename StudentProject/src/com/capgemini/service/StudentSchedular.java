package com.capgemini.service;

import com.capgemini.bean.Student;


public class StudentSchedular {
	
	private Student[] student=new Student[10];
	
	
	private int countstudent;
	
	public String enterdetails(int rollNumber,String name, String[] courses) 
	{
		int doesExists=0; //doesExists is used as a flag that is used to check whether the entered RollNumber already exists or not.
		for(int i=0;i<student.length;i++) {
		if(student[i]==null)
		{		break;}
		else
			if (student[i].getRollNumber()==rollNumber) {
			
				doesExists=1;
			}
		}
		if(doesExists==1) {
		System.out.println("Roll number already Exists");
		return "Details not entered";
		}
		else {
			student[countstudent++]=new Student(rollNumber,name,courses);
			return "Details entered successfully";
		}
		
	}
	
	
	public void showAllDetails() 
	{
		System.out.println("Details of all students are:");
		for (int i=0;i<countstudent;i++)
		{
			String courses[]=student[i].getCourses();
			System.out.println("Roll no is:"+ student[i].getRollNumber()+"\nName is "+ student[i].getName()+"\nSelected courses are:");
			for(int j=0;j<courses.length;j++) {
				System.out.println(courses[j]);
			}
		}
	}


	public void studentcountbycourse(String coursename) {
		int counter=0;
		
		for(int i=0;i<countstudent;i++) {
			
			for (String courses:student[i].getCourses())
			{
				
				if (coursename.equals(courses)) {
					
					counter++;
	//				break;
				}
			}
			
		}
		
		System.out.println( counter +" enrolled in "+coursename);
		
	}
	
	public void studentbycoursename(String coursestudent) {
		
		for(int i=0;i<countstudent;i++)
		{
			for(String course:student[i].getCourses()) 
			{
				if(coursestudent.equalsIgnoreCase(course))
				{
					System.out.println("Roll Number: "+student[i].getRollNumber() );
					System.out.println("Name: "+student[i].getName());
					System.out.print("Courses Registered: ");
					for(String course1:student[i].getCourses()) 
					{
						System.out.print(course1+" ");
					}
					System.out.println("\n");
				}
			}
		}
	}		
	
	
	
	
	public void studentbyrollnumber(int roll) {
		
		int flag=0;
		for(int i=0;i<countstudent;i++) {
			
			
			if(roll==student[i].getRollNumber()) {
				String[] courses=student[i].getCourses();
				
				System.out.println("Your name is "+student[i].getName()+" and your selected courses are: ");
				
				for(int j=0;j<courses.length;j++){
					
					System.out.println(courses[j]);
					
				}
				flag=1;
				break;
				
				
				//countstudent++;

			}}
							
			if(flag==0) {
				
				System.out.println("Entered roll number does not exist");	

			}
			
		}
		
				

	}
	
