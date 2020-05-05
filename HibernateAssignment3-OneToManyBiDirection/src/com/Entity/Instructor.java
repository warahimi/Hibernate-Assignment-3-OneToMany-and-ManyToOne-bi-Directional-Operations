package com.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	//to map the instructor to the courses // 
	@OneToMany(mappedBy  = "instructor" , cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	//mappedBy="instructor" - this will refer to the instructor property in the course class.it uses the information from the Courses class @joinColumn to help find the associated course for the instructor
	private List<Course> courses; // list of courses because an instructor can have many courses
	

	
	public void addAllCourses(Course theCourse)  // this is a convience method for bi-drectional 
	{
		if(courses == null)
		{
			courses = new ArrayList<Course>();
		}
		courses.add(theCourse);
		theCourse.setInstructor(this); // this will set the 2 way link between the instructo and the course
	}
	

	//Constructors
	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	//getter and setter
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}



	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "\nInstructor\n---------------------------"+"\nID: " + id + "\nFirst Name: " + firstName + ",\nLast Name: " + lastName + "\nEmail: " + email
				+"\n\nInstructor_Detail\n---------------------------" +"\nInstuctorDetail ID:"+ instructorDetail.getId() + "\nYoutube Channel:"+instructorDetail.getYoutubeChannle()+"\nHobby: "+instructorDetail.getHobby();
		
	}
	
	
	

}
