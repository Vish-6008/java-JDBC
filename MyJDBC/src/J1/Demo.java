/********************************************************************************************
 *   COPYRIGHT (C) 2022 TONAL INC
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without  written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  Connecting driver to database using credentials.
 *   Project:  Demo
 *   Platform: JavaSE-22.0.1
 *   IDE:  	   Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	 Version: 2024-03 (4.31.0)
 *   Build id: 20240307-1437 
 *********************************************************************************************/



package J1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws SQLException {
		
		String sql="SELECT * FROM public.employee";
		
		String url="jdbc:postgresql://localhost:5433/postgres";
		String username="postgres";
		String password="Vishwa123";
		
		Connection con=DriverManager.getConnection(url, username, password);
		
		Statement stm=con.createStatement();
		
		ResultSet r=stm.executeQuery(sql);
		while(r.next())
		{
			System.out.println(r.getString("EID"));
			System.out.println(r.getString("FirstName"));
		}
		// TODO Auto-generated method stub

	}

}
