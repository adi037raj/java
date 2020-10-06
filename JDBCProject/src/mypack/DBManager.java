package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager
{
	public static int insertStudent(Student std)
	{
		int r=0;
		Connection conn=DBConnection.createConnection();
		if(conn==null)
			return -1;
		String query="insert into student values(?,?,?,?)";
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1, std.getReg());
			stmt.setString(2, std.getName());
			stmt.setString(3, std.getBranch());
			stmt.setInt(4, std.getMarks());
			r=stmt.executeUpdate();
			DBConnection.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String msg=e.getMessage().toLowerCase();
			if(msg.contains("duplicate entry"))
				return -2;
			return -3;
		}
		return r;
	}
	
	public static ArrayList<Student> getAllStudents()
	{
		ArrayList<Student> list_std=new ArrayList<>();
		Connection conn=DBConnection.createConnection();
		if(conn==null)
			return null;
		String query="select * from student";
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs= stmt.executeQuery();
			String reg,name,branch;
			int marks;
			while(rs.next())
			{
				reg=rs.getString(1);
				name=rs.getString(2);
				branch=rs.getString(3);
				marks=rs.getInt(4);
				Student std=new Student(reg, name, branch, marks);
				list_std.add(std);
			}
			rs.close();
			DBConnection.closeConnection(conn);
			return list_std;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static int deleteStudent(Student std)
	{
		int r=0;
		Connection conn=DBConnection.createConnection();
		if(conn==null)
			return -1;
		String query="delete from student where RegNo=?";
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1, std.getReg());
			r=stmt.executeUpdate();
			DBConnection.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return -2;
		}
		return r;
	}
	
	public static int updateStudent(Student std)
	{
		int r=0;
		Connection conn=DBConnection.createConnection();
		if(conn==null)
			return -1;
		String query="update student set Name=?,Branch=?,Marks=? where RegNo=?";
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1, std.getName());
			stmt.setString(2, std.getBranch());
			stmt.setInt(3, std.getMarks());
			stmt.setString(4, std.getReg());
			r=stmt.executeUpdate();
			DBConnection.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return -2;
		}
		return r;
	}
}
