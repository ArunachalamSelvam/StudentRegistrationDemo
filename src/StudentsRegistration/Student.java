package StudentsRegistration;

import java.util.*;
public class Student {
	private int id;
	private String name;
	private String gender;
	private int age;
	private String dateOfBirth;
	private String phoneNumber;
	private String location;
	
	Student(int id, String name,String gender,String location,String phoneNumber, String dateOfBirth,int age){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
