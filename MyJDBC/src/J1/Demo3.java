/********************************************************************************************
 *   COPYRIGHT (C) 2022 TONAL INC
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without  written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  Accessing the data from the database from Java eclipse..
 *   Project:  Demo3
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

public class Demo3 {

	public static void main(String[] args) throws SQLException {
		
		
		
		String title="SELECT  * FROM public.crevavi";
		
		String title2="SELECT DISTINCT E_ID,E_NAME FROM public.CREVAVI WHERE E_LOCATION='BANGLORE'";
		
		String title3="SELECT DISTINCT E_NAME,E_ID FROM crevavi WHERE E_NAME LIKE 'V%';";
		
		String url="jdbc:postgresql://localhost:5433/Practicee";
		String username="postgres";
		String password="Vishwa123";
		
		
		
		Connection conn=DriverManager.getConnection(url, username, password);
		// TODO Auto-generated method stub
		
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery(title);
		
		
		while(rs.next()) {
		    System.out.println(rs.getString("E_ID"));
		    System.out.println(rs.getString("E_NAME"));
		    System.out.println(rs.getString("E_LOCATION"));
		    System.out.println(rs.getString("E_SALLARY"));
		}
		
		ResultSet rs1=st.executeQuery(title2);

		// Corrected: Use rs1 instead of rs
//		while(rs1.next()) {
//		    System.out.println(rs1.getString("E_ID"));
//		    System.out.println(rs1.getString("E_NAME"));
//		}
		
		
		
		//want to get particular data's then need to create resultset and onemore while condition
//		ResultSet rs2=st.executeQuery(title3);
//		while(rs2.next()) {
//			System.out.println(rs2.getString("E_NAME"));
//			System.out.println(rs2.getString("E_ID"));
//		}
//		
		conn.close();

		
	

	}

}
