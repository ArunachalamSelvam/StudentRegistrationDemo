package StudentsRegistration;
import java.sql.*;
import java.util.Scanner;
//import java.util.List;
public class StudentDAO {
	
	private static final String SELECT_STUDENT = "select * from student_table";
	private static final String INSERT_NEW_STUDENT = "insert into student_table"+"(student_id,student_name,gender,student_place,contact_no,dateOfBirth,age)" +"values (?,?,?,?,?,?,?)";
	private static final String UPDATE_STUDENT_SQL = "update student_table set student_name=?, gender = ?, student_place=?, contact_no=?, dateOfBirth=?,age=? where student_id=?";
	private static final String DELETE_STUDENT_SQL = "delete from student_table where student_id=?";
	
	public StudentDAO() {}
	protected static Connection getConnection() {
		Connection con = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/arundb","root","Arun@1103");
		}catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
//            catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return con;
		
	}
	public static void selectAllStudents(){
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = StudentDAO.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(SELECT_STUDENT);
			
			System.out.println("\n\t-------Student Details-------\n");

			int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
            	if(i==5) {
            		 System.out.printf("%-7s", rs.getMetaData().getColumnName(i));
            	}
            	else{
            		System.out.printf("%-15s", rs.getMetaData().getColumnName(i));
            	}
                
            }
            System.out.println("\n");
			//System.out.println("ID  "+ "Name "+ " Location  "+ " Mobile No "+ "   DOB   "+"  Age ");
			
			// Print data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    // Determine the data type of the column
                    int columnType = rs.getMetaData().getColumnType(i);
                    if (columnType == java.sql.Types.INTEGER) {
                    	if(i==5) 
                    	{
                    		System.out.printf("%-7d", rs.getInt(i));
                    	}else {
                    		System.out.printf("%-15d", rs.getInt(i));
                    	}
                    } else {
                        System.out.printf("%-15s", rs.getString(i));
                    }
                }
                System.out.println();
            }
//			while(rs.next()) {
//			System.out.println(rs.getInt(1)+" " + rs.getString(2)+" "+ rs.getString(3) + " " + rs.getString(4) +" " + rs.getString(5) + " " + rs.getInt(6));
//			}
			con.close();
		}
		catch(Exception e) {}
	}


	public static int insertStudent(Student s) {
		int status =0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_NEW_STUDENT);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getGender());
			pstmt.setString(4, s.getLocation());
			pstmt.setString(5, s.getPhoneNumber());
			pstmt.setString(6, s.getDateOfBirth());
			pstmt.setInt(7, s.getAge());
			status = pstmt.executeUpdate();
			con.close();
		}catch(Exception e) {}
		return status;
	}
	
	public static boolean deleteStudent() {
		Scanner sc  = Student.getScanner();
		System.out.print("Enter Student Id : ");
		int id = sc.nextInt();
		//sc.close();
		boolean rowsDeleted=false;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_STUDENT_SQL);
			pstmt.setInt(1, id);
			rowsDeleted = pstmt.executeUpdate()>0;
			con.close();
		}catch(Exception e) {}
		return rowsDeleted;
	}
	
	public static boolean updateStudent(Student s) {
		boolean rowsUpdated = false;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_STUDENT_SQL);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getGender());
			pstmt.setString(3, s.getLocation());
			pstmt.setString(4, s.getPhoneNumber());
			pstmt.setString(5, s.getDateOfBirth());
			pstmt.setInt(6, s.getAge());
			pstmt.setInt(7, s.getId());
			
			rowsUpdated = pstmt.executeUpdate()>0;
		}catch(Exception e) {}
		
		return rowsUpdated;
	}
	
	
	
}	