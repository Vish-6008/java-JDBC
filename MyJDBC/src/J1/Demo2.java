/********************************************************************************************
 *   COPYRIGHT (C) 2022 TONAL INC
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without  written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  Creating and executing the query in database using eclipse..
 *   Project:  Demo2
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

public class Demo2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String title="SELECT * FROM public.VISHWA";
		
		//Class.forName("postgresql.jdbc.driver.postgresqlDriver");
		
		
					//jdbc,database,localhost,port No,password,db name
		String url="jdbc:postgresql://localhost:5433/Crevavi";  //carefull with db name lastly
		
		String username="postgres";
		
		String password="Vishwa123";
		
		
		
		
		//creating connection
		Connection conn=DriverManager.getConnection(url,username, password);
		
		
		//creating a statement
		Statement smt=conn.createStatement();
		
		
		ResultSet rs=smt.executeQuery(title);
		
		while(rs.next()) {
			System.out.println(rs.getString("Vid"));
			System.out.println(rs.getString("Vname"));
			System.out.println(rs.getString("Vplace"));
		}
		
		conn.close();
		// TODO Auto-generated method stub

	}

}
