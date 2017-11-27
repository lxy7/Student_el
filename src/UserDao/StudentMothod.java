package UserDao;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Bean.Student;
import Util.Db_util;


public class StudentMothod {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

    public boolean add(Student us) throws SQLException
    {
    	
    	
    	String sex = us.getSex().equals("1")?"男":"女";
    	conn = Db_util.getConnection();
    	try {
    		 
    		String a=new String(us.getName().getBytes("ISO-8859-1"),"utf-8");
    		String b=new String(us.getGrad().getBytes("ISO-8859-1"),"utf-8");
    		String c=new String(us.getAddress().getBytes("ISO-8859-1"),"utf-8");
			stmt=conn.prepareStatement("insert into stu values(?,?,?,?,?,?)");
			 stmt.setString(1,us.getId());
		        stmt.setString(2,a);
		        stmt.setString(3,us.getAge());
		        stmt.setString(4,sex);
		        stmt.setString(5,b);
		        stmt.setString(6,c);
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Db_util.release(conn, stmt, rs);
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
	 
	 
    	Student s= new Student();
    	try {
    		conn = Db_util.getConnection();
			stmt=conn.prepareStatement("select * from stu where sid = ?");
			
			stmt.setString(1,id);
			

			rs=stmt.executeQuery();
			System.out.println(rs.next());
			s.setId(new String(rs.getString(1).getBytes("ISO-8859-1"),"utf-8"));
	        s.setName(new String(rs.getString(2).getBytes("ISO-8859-1"),"utf-8"));
	        s.setAge(new String(rs.getString(3).getBytes("ISO-8859-1"),"utf-8"));
	        s.setSex(new String(rs.getString(4).getBytes("ISO-8859-1"),"utf-8"));
	        s.setGrad(new String(rs.getString(5).getBytes("ISO-8859-1"),"utf-8"));
	        s.setAddress(new String(rs.getString(6).getBytes("ISO-8859-1"),"utf-8"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Db_util.release(conn, stmt, rs);
		}
    	
        	
    	return s;
        
    }
 public boolean delete(String id)
 {
	 int re=0;
	
	
	 try {
		 conn = Db_util.getConnection();
	 stmt=conn.prepareStatement("delete from stu where sid = ?");
	    stmt.setString(1,id);
	   
		   re =stmt.executeUpdate();
			System.out.println(re);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Db_util.release(conn, stmt, rs);
		}
	if(re==1)
	{
		return true;
	}
	else
	{
		return false;
	}
 }
 
 public boolean update(Student us)
 {
	 int re=0;
	 String sex = us.getSex().equals("1")?"男":"女";
	
	 
	 String a;
	try {
		
		a = new String(us.getId().getBytes("ISO-8859-1"),"utf-8");
		String b = new String(us.getName().getBytes("ISO-8859-1"),"utf-8");
		 
		 String c = new String(us.getGrad().getBytes("ISO-8859-1"),"utf-8");
		 String d = new String(us.getAddress().getBytes("ISO-8859-1"),"utf-8");
		 try {
			 conn = Db_util.getConnection();
				stmt=conn.prepareStatement("update  stu set sname=?,sage =?,ssex =?,sgrad =?,saddress =? where sid = ?");
				
				stmt.setString(1,b);
				    stmt.setString(2,us.getAge());
				    stmt.setString(3,sex);
				    stmt.setString(4,c);
				    stmt.setString(5,d);
				    stmt.setString(6,a);
				     re = stmt.executeUpdate();
				    
				    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}finally{
		Db_util.release(conn, stmt, rs);
	}
	 
	 
	 
 
	   
		if(re!=0)
		{
			return true;
		}
		else
			return false;
	   
 }
 
 
 /*
  * 根据学生的姓名查询数据
  * */
 public ArrayList<Student> selectAll(String name)
 {
	 ArrayList<Student> sList  = new ArrayList<>();
	 
	
 	
 	try {
 		 conn = Db_util.getConnection();
			stmt=conn.prepareStatement("select * from stu where sname = ?");
			stmt.setString(1,name);
			rs=stmt.executeQuery();
			
			System.out.println(rs.next());
			while(rs.next()){
			Student s= new Student();
			
			s.setId(new String(rs.getString(1).getBytes("ISO-8859-1"),"utf-8"));
	        s.setName(new String(rs.getString(2).getBytes("ISO-8859-1"),"utf-8"));
	        s.setAge(new String(rs.getString(3).getBytes("ISO-8859-1"),"utf-8"));
	        s.setSex(new String(rs.getString(4).getBytes("ISO-8859-1"),"utf-8"));
	        s.setGrad(new String(rs.getString(5).getBytes("ISO-8859-1"),"utf-8"));
	        s.setAddress(new String(rs.getString(6).getBytes("ISO-8859-1"),"utf-8"));
	        
	        sList.add(s);
	        System.out.println(s);
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Db_util.release(conn, stmt, rs);
		}
 	
     	
 	return sList;
     
 }
 public ArrayList<Student> getSname(String sname){
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from stu where sname=?";
		try {
			conn = Db_util.getConnection();
			ps = conn.prepareStatement(sql);			
			ps.setString(1, sname);
			rs = ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getString("sid"));
				stu.setName(rs.getString("sname"));
				stu.setSex(rs.getString("ssex"));
				stu.setAge(rs.getString("sage"));
				stu.setAddress(rs.getString("saddress"));
				stu.setGrad(rs.getString("grad"));
				stuList.add(stu);				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			Db_util.release(conn, stmt, rs);
		}		
		return stuList;		
	}

 
}
