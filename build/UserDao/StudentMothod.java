package UserDao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Student;
import Util.Util;

public class StudentMothod {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

    public boolean add(Student us) throws SQLException
    {
    	Util util = new Util();
    	
    	String sex = us.getSex().equals("1")?"ÄÐ":"Å®";
    	conn = util.getConnection();
    	try {
			stmt=conn.prepareStatement("insert into stu values(?,?,?,?,?,?)");
			 stmt.setString(1,us.getId());
		        stmt.setString(2,us.getName());
		        stmt.setString(3,us.getAge());
		        stmt.setString(4,sex);
		        stmt.setString(5,us.getGrad());
		        stmt.setString(6,us.getAddress());
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	int re = stmt.executeUpdate();
        if(re != 0)
        {
        	return true;
        }
        else
        {
        	
        	return false;
        }	
    	
       

    }
 public Student select(String id)
    {
	 Util util = new Util();
	 conn = util.getConnection();
    	Student s= new Student();
    	try {
			stmt=conn.prepareStatement("select * from stu where sid = ?");
			
			stmt.setString(1,id);
			
			rs=stmt.executeQuery();
			System.out.println(rs.next());
			s.setId(rs.getString(1));
	        s.setName(rs.getString(2));
	        s.setAge(rs.getString(3));
	        s.setSex(rs.getString(4));
	        s.setGrad(rs.getString(5));
	        s.setAddress(rs.getString(6));
			
			
	        
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
        	
    	return s;
        
    }
 public int delete(String id)
 {
	 int re=0;
	 Util util = new Util();
	 conn = util.getConnection();
	 try {
	 stmt=conn.prepareStatement("delete from stu where sid = ?");
	    stmt.setString(1,id);
	   
		   re =stmt.executeUpdate();
			System.out.println(re);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return re;
 }
 
 public boolean update(Student us)
 {
	 int re=0;
	 String sex = us.getSex().equals("1")?"ÄÐ":"Å®";
	 Util util = new Util();
	 conn = util.getConnection();
	 System.out.println("haha");
	 try {
		stmt=conn.prepareStatement("update  stu set sname=?,sage =?,ssex =?,sgrad =?,saddress =? where sid = ?");
		System.out.println("hahaa");
		stmt.setString(1,us.getName());
		    stmt.setString(2,us.getAge());
		    stmt.setString(3,sex);
		    stmt.setString(4,us.getGrad());
		    stmt.setString(5,us.getAddress());
		    stmt.setString(6,us.getId());
		     re = stmt.executeUpdate();
		    
		    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
	   
		if(re!=0)
		{
			return true;
		}
		else
			return false;
	   
 }
 
}
