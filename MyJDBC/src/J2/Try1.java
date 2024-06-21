package J2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Try1 {

	public static void main(String[] args) throws SQLException {
		
		String headline="SELECT * FROM public.employees ORDER BY employee_id ASC  ";
		
		String url="jdbc:postgresql://localhost:5433/Practicee";
		
		String username="postgres";
		
		String password="Vishwa123";
		
		
		
		Connection con=DriverManager.getConnection(url, username, password);
		
		Statement stm=con.createStatement();
		
		ResultSet rs=stm.executeQuery(headline);
		
		while(rs.next()) {
			System.out.println(rs.getString(("employee_id")));
			System.out.println(rs.getString(("first_name")));
			System.out.println(rs.getString(("last_name")));
			System.out.println(rs.getString("department_id"));
		}
		
		con.close();
		// TODO Auto-generated method stub

	}

}
