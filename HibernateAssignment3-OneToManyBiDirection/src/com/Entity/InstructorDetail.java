package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannle;

	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;
	
	public InstructorDetail() {
		// TODO Auto-generated constructor stub
	}

	public InstructorDetail(String youtubeChannle, String hobby) {
		this.youtubeChannle = youtubeChannle;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannle() {
		return youtubeChannle;
	}

	public void setYoutubeChannle(String youtubeChannle) {
		this.youtubeChannle = youtubeChannle;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return  "\n\nInstructor_Detail\n---------------------------" + "\nInstuctorDetail ID:" + id + "\nYoutube Channel:"+youtubeChannle+"\nHobby: "+ hobby
				+"\n\nInstructor\n---------------------------"+"\nID: " + id + "\nFirst Name: " + instructor.getFirstName() + ",\nLast Name: " + instructor.getLastName() + "\nEmail: " + instructor.getEmail()
				;
		
	}
	
	
	
	
	
	
}
