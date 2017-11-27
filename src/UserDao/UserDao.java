package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Util.Db_util;


public class UserDao {
	
	
	private String  name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
		// TODO Auto-generated constructor stub

	public boolean getValid()
	{
		
		int flag = 0;
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql ="select * from login";
				
				try {
					cn= Db_util.getConnection();
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						if (this.getName().equals(rs.getString(2))&&this.getPassword().equals(rs.getString(3)))
						
						{
							flag = 1;
							break;
						}
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch bloc
					}
				if(flag==1)
				{
					return true;
				}
				else
				{
					return false;
				}
				
				
				
						
	}
	public UserDao() {
		
	}

}
