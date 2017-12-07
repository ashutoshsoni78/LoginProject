package com.as.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService 
{
	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";
	public UserService() 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			st = con.createStatement();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		public String checkLogin(String uname, String upwd) 
		{
			try 
			{
				rs = st.executeQuery("select * from reg_Users where uname = '"+uname+"' and upwd = '"+upwd+"'");
				boolean b = rs.next();
				if(b == true) 
				{
					status = "SUCCESS";
				}
				else 
				{
					status = "FAILURE";
			    }
		    } catch (Exception e) {
			e.printStackTrace();
			}
			return status;
		}
		public String registration(String uname, String upwd, String uemail, String umobile) 
		{
			try 
			{
				rs = st.executeQuery("select * from reg_Users where uname = '"+uname+"'");
				boolean b = rs.next();
				if(b == true) {
				status = "USER EXISTED ALREADY";
				}else {
				st.executeUpdate("insert into reg_Users values('"+uname+"','"+upwd+"','"+uemail+"','"+umobile+"')");
				status = "SUCCESS";
				}
			} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
			}
			return status;
	    }
}

