package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	String title;
	
	//we can map many courses to one instructor 
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "constructor_id") //join column is the the FK column in the course table that map to instructor table pk id, to find the given instrucot for the give course
	private Instructor instructor; // because the information comes from instructor table//creates the relationship between 2 tables
	
	//Constructor
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	
	//Getters and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	//toString()
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
	
	
	
	

}
