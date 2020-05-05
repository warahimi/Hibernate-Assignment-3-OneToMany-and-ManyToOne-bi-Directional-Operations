package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.Course;
import com.Entity.Instructor;
import com.Entity.InstructorDetail;

public class Delete {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session theSession = factory.getCurrentSession();
		
		try {
			System.out.println("From which table you want to delete ?");
			System.out.println("1. Instructor Table.\n2. Instructor_Detail Table.\n3. Course Table.\nEnter your choice: ");
			int choice = input.nextInt();
			if(choice == 1)
			{	
				System.out.print("Enter the Instructor ID you want to delete: ");
				int instructorID = input.nextInt();
				theSession.beginTransaction();
				Instructor reterievedInstructor = theSession.get(Instructor.class, instructorID);
				if(reterievedInstructor != null)
				{
					System.out.println("\n");
					System.out.println(reterievedInstructor);
					System.out.println("---------------------------------");
					System.out.println("Are you sure you want to delete the above instructor ? this will delete instructDetail also.\n(y/n): ");
					String delteChoice = br.readLine();
					if(delteChoice.equalsIgnoreCase("y"))
					{
						theSession.delete(reterievedInstructor);
						theSession.getTransaction().commit();
						System.out.println("\nObjects Deleted from both tables");
					}
				}
				else
				{
					System.out.println("\nThe instructor ID does not exist. Please Enter a Valid ID.");
				}
				
				
			}
			else if(choice == 2)
			{
				System.out.print("Enter the InstructorDetail ID you want to delete: ");
				int instructorDetailID = input.nextInt();
				theSession.beginTransaction();
				InstructorDetail reterievedInstructorDetail = theSession.get(InstructorDetail.class, instructorDetailID);
				if(reterievedInstructorDetail != null)
				{
					System.out.println("\n");
					System.out.println(reterievedInstructorDetail);
					System.out.println("---------------------------------");
					System.out.println("Are you sure you want to delete the above instructorDetail ? this will delete instructor also.\n(y/n): ");
					String delteChoice = br.readLine();
					if(delteChoice.equalsIgnoreCase("y"))
					{
						theSession.delete(reterievedInstructorDetail);
						theSession.getTransaction().commit();
						System.out.println("\nObjects Deleted from both tables");
					}
					
				}
			}
				else if(choice == 3)
				{
					System.out.print("Enter the course title ID you want to delete: ");
					int courseTitlelID = input.nextInt();
					theSession.beginTransaction();
					Course course = theSession.get(Course.class, courseTitlelID);
					if(course != null)
					{
						System.out.println("\n");
						System.out.println("Course ID: "+course.getId());
						System.out.println("Course Title: "+course.getTitle());
						System.out.println("---------------------------------");
						System.out.println("Are you sure you want to delete this course ? this will not delete instructor/InstructorDetail.\n(y/n): ");
						String delteChoice = br.readLine();
						if(delteChoice.equalsIgnoreCase("y"))
						{
							theSession.delete(course);
							theSession.getTransaction().commit();
							System.out.println("\nObject deleted only from course table");
						}
						
					}
				
					else 
					{
						System.out.println("\nThe Course ID does not exist. Please Enter a Valid ID.");
					}
				
				}	
			
			else {
				System.out.println("Invalid Entry...");
			}
				
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
