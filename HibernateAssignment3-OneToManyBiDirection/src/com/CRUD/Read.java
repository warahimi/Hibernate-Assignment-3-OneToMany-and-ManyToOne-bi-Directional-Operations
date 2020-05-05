package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.Course;
import com.Entity.Instructor;
import com.Entity.InstructorDetail;

public class Read {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session theSession = factory.getCurrentSession();
		
		try {
			System.out.println("From which table you want to read data?");
			System.out.println("1. Instructor Table.\n2. Instructor_Detail Table.\n3. Course Table.\nEnter your choice: ");
			int choice = input.nextInt();
			if(choice == 1)
			{	
				System.out.print("Enter the Instructor ID: ");
				int instructorID = input.nextInt();
				theSession.beginTransaction();
				Instructor reterievedInstructor = theSession.get(Instructor.class, instructorID);
				System.out.println("\nReading Data from Instructor Table:\n");
				System.out.println(reterievedInstructor);
				printCourses(reterievedInstructor);
				theSession.getTransaction().commit();
			}
			else if(choice == 2)
			{
				System.out.print("Enter the InstructorDetail ID: ");
				int instructorDetailID = input.nextInt();
				theSession.beginTransaction();
				InstructorDetail reterievedDetailInstructor = theSession.get(InstructorDetail.class, instructorDetailID);
				System.out.println("\nReading Data from InstructorDetail Table:\n");
				System.out.println(reterievedDetailInstructor);
				Instructor reterievedInstructor = reterievedDetailInstructor.getInstructor();
				printCourses(reterievedInstructor);
				theSession.getTransaction().commit();
			}
			else if(choice == 3)
			{
				System.out.print("Enter the course tile id: ");
				int courseTitleID = input.nextInt();
				theSession.beginTransaction();
				Course course = theSession.get(Course.class, courseTitleID);
				System.out.println("Course ID: "+course.getId());
				System.out.println("Course Title: "+course.getTitle());
				System.out.println("\nThe associated instructor to this course is");
				Instructor instructor = course.getInstructor();
				System.out.println(instructor);
				theSession.getTransaction().commit();
				
			}
			else {
				System.out.println("Invalid Entery");
			}
				
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	private static void printCourses(Instructor reterievedInstructor) {
		System.out.println("\n\nCourse titles associted to this instructor:");
		List<Course> listOfCourses = reterievedInstructor.getCourses();
		for(Course course : listOfCourses)
		{
			System.out.println("Course ID: "+course.getId());
			System.out.println("Course Name: "+course.getTitle());
			System.out.println();
		}
	}

}
