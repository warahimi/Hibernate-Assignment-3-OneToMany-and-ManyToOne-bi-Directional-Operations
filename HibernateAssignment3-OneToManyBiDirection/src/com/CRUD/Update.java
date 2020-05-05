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

public class Update {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session theSession = factory.getCurrentSession();
		
		try {
			System.out.println("Which Table you want to update?");
			System.out.println("1. Instructor Table.\n2. Instructor_Detail Table.\n3. Course Table.\nEnter your choice: ");
			int choice = input.nextInt();
			if(choice == 1)
			{	
				System.out.print("Enter the Instructor ID you want to update: ");
				int instructorID = input.nextInt();
				theSession.beginTransaction();
				Instructor reterievedInstructor = theSession.get(Instructor.class, instructorID);
				if(reterievedInstructor !=null)
				{
					System.out.println("\n--------------------------------");
					System.out.println("ID: "+reterievedInstructor.getId());
					System.out.println("First Name: "+reterievedInstructor.getFirstName());
					System.out.println("Last Name: "+reterievedInstructor.getLastName());
					System.out.println("Email: "+reterievedInstructor.getEmail());
					System.out.println("--------------------------------");
					System.out.println("What you want to update?\n1. First Name:\n2. Last Name:\n3. Email:");
					int updateChoice = input.nextInt();
					if(updateChoice == 1)
					{
						System.out.print("Enter the new First Name: ");
						String x = br.readLine();
						reterievedInstructor.setFirstName(x);
						theSession.getTransaction().commit();
					}
					else if(updateChoice == 2)
					{
						System.out.print("Enter the new Last Name: ");
						String x = br.readLine();
						reterievedInstructor.setLastName(x);
						theSession.getTransaction().commit();
					}
					else if(updateChoice == 3)
					{
						System.out.print("Enter the new Email: ");
						String x = br.readLine();
						reterievedInstructor.setEmail(x);
						theSession.getTransaction().commit();
					}
					else
					{
						System.out.println("Invalid Entry!");
					}
					
				}
				else
				{
					System.out.println("\nThe ID does not exist. Please Enter a valid ID");
				}
				
				
			}
			else if(choice == 2)
			{
				System.out.print("Enter the InstructorDetail ID: ");
				int instructorDetailID = input.nextInt();
				theSession.beginTransaction();
				InstructorDetail reterievedDetailInstructor = theSession.get(InstructorDetail.class, instructorDetailID);
				if(reterievedDetailInstructor != null)
				{
					System.out.println("\n--------------------------------");
					System.out.println("Youtube Channel: "+reterievedDetailInstructor.getYoutubeChannle());
					System.out.println("Hobby: "+reterievedDetailInstructor.getHobby());
					System.out.println("--------------------------------");
					System.out.println("What you want to update?\n1. Youtube Channel:\n2. Hobby:");
					int updateChoice = input.nextInt();
					if(updateChoice == 1)
					{
						System.out.print("Enter the new Youtube Channel: ");
						String x = br.readLine();
						reterievedDetailInstructor.setYoutubeChannle(x);
						theSession.getTransaction().commit();
					}
					else if(updateChoice == 2)
					{
						System.out.print("Enter the new Hobby: ");
						String x = br.readLine();
						reterievedDetailInstructor.setHobby(x);
						theSession.getTransaction().commit();
					}
					else
					{
						System.out.println("Invalid Entry!");
					}
					
				}
				else
				{
					System.out.println("\nThe ID does not exist. Please Enter a valid ID");
				}
				
			}
			
			else if(choice == 3)
			{	
				System.out.print("Enter the Course ID you want to update: ");
				int courseID = input.nextInt();
				theSession.beginTransaction();
				Course course = theSession.get(Course.class, courseID);
				if(course !=null)
				{
					System.out.println("\n--------------------------------");
					System.out.println("Course ID: "+course.getId());
					System.out.println("Course Title: "+course.getTitle());
					System.out.println("--------------------------------");
					
					System.out.print("Enter the new Course title: ");
					String x = br.readLine();
					course.setTitle(x);
					
					theSession.getTransaction().commit();
					System.out.println("Course Updated");
				}
				else
				{
					System.out.println("\nThe course ID does not exist. Please Enter a valid ID");
				}
				
				
			}
			
			else
			{
				System.out.println("Invalid Entry!");
			}
				
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
