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
	
	public static Scanner getScanner() {
		Scanner sc = new Scanner(System.in);
		return sc;
	}
	
	public static boolean isValidName(String name) {
        // Example criteria: Alphabetic characters only, length between 3 and 20
        return name.matches("[a-zA-Z]+") && name.length() >= 3 && name.length() <= 20;
    }
	
	public static boolean isValidNo(String no) {
        // Example criteria: Alphabetic characters only, length between 3 and 20
        return no.matches("[0-9]+") && no.length() == 10;
    }
	
	public static Student createStudent()
	{
		Scanner s = getScanner();
		int option = 0;
		
		String name = null;
		String location= null;
		String phoneNo = null;
		String gender = null;
		System.out.print("Enter the Id: ");
		int id = s.nextInt();
		
		while(name == null || !isValidName(name)) 
		{
			System.out.print("Enter the Student Name : ");
			
			name = s.next().toUpperCase().trim();
			if(!isValidName(name))
			{
			 System.out.println("\n Please enter the valid Name(Only alphabets).");
			}
		}
		
			do {
				System.out.print("Select the Student Gender : ");
				System.out.println("\n1. MALE.\n2. FEMALE");
				System.out.print("\n\tPlease Choose the Option : ");
				option = s.nextInt();
				if(option == 1)
				{
					gender = "MALE";
				}
				else if (option ==2) 
				{
					gender = "FEMALE";
				}
				else
				{
					System.out.println("Enter the valid Option.");
				}
			} while(option ==0 && option>2);	
		
		while(location == null || !isValidName(location)) 
		{
			System.out.print("Enter the Student Location : ");
			
			location = s.next().toUpperCase().trim();
			//st.setLocation(location);
			
			if(!isValidName(location)) 
			{
			 System.out.println("\n Please enter the valid Location(Only alphabets).");
			}
		}
		
		
		while(phoneNo == null || !isValidNo(phoneNo))
		{
			System.out.print("Enter the Student PhoneNo : ");
			phoneNo = s.next().toUpperCase().trim();
			if(!isValidNo(phoneNo)) 
			{
				System.out.println("\n Please enter the valid Phone Number.");
			}
		}
		
		s.nextLine();
		System.out.print("Enter the Student DateOfBirth : ");
		String dob = s.nextLine();
		
		System.out.print("Enter Student Age : ");
		int age = s.nextInt();
		
		return new Student(id,name,gender,location,phoneNo,dob,age);
	}
	
	
	public static void main(String [] args) {
		Scanner sc = getScanner();
		Student student;
		
		while(true) {
			System.out.println("\t-----Welcome to Student Management System -----\n");
			
			System.out.println("1. View Student Details.\n2. Add New Student.\n3. Update Student.\n4. Delete Student.\n5. Exit");
			System.out.print("\nEnter the option : ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1 : 	
					StudentDAO.selectAllStudents();	
					break;
				
				case 2: 
					student = createStudent();
					int out = StudentDAO.insertStudent(student);
					if(out>0) 
					{
						System.out.println("\nStudent inserted Successfully.");
					}
					else 
					{
						System.out.println("\nStudent insertion failed.");
					}
				
					break;
			
				case 3:
					student = createStudent();
					boolean isUpdated = StudentDAO.updateStudent(student);
					if(isUpdated) 
					{
						System.out.println("\nStudent Details Updated.");
					}
					else 
					{
						System.out.println("\nStudent updation Failed.");
					}
				
					break;
			
				case 4:	
					boolean isDeleted = StudentDAO.deleteStudent();
					if(isDeleted)
					{
						System.out.println("\nStudent Details deleted successfully.");
					}
					else
					{
						System.out.println("\nStudent Deletion Failed.");
					}
			
					break;
			
				case 5:
					System.out.println("\nYour session has ended.");
					break;
				
				default:
					System.out.println("Invalid choice. Try again.");
			}
			
			if(choice == 5) 
			{
				break;
			}
			System.out.println("\n");
		}
	}

}
