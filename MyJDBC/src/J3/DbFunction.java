package J3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DbFunction 
{
	
	//connection 
	public Connection connect_to_db(String dbname,String user ,String pass) {
		Connection conn=null;
		try {
			//Class.forName("org.postgresql:Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/"+dbname,user,pass);
			if(conn!=null)
			{
				System.out.println("connection established");
			}else
			{
				System.out.println("connection failed");
				}
			}
		catch(Exception e)
		{
				System.out.println(e);}
		return conn;
		} 
	
	//Create the data 
		public void createTable(Connection conn,String table_name) {
			Statement statement;
			try {
				String query="create table " +table_name+"(empid SERIAL,name VARCHAR(200),address VARCHAR(200),primary key(empid));";
				statement =conn.createStatement();
				statement.executeUpdate(query);
				System.out.println("table created..");
				}
			catch(Exception e)
			{
				System.out.println(e);
				}
			}
		
		//Insert the data into table
		public void insert_row(Connection conn,String table_name,String name,String address) {
			Statement statement;
			try {
				String query=String.format("insert into %s(name,address) VALUES('%s','%s');",table_name,name,address);
				statement =conn.createStatement();
				statement.executeUpdate(query);
				System.out.println("Row inserted..");
				}
			catch(Exception e)
			{
				System.out.println(e);
				}
			}
		
		//Read the data from table
		public void read_data(Connection conn,String table_name) {
			Statement statement;
			ResultSet rs=null;
			try {
				String query=String.format("select * from %s",table_name);
				statement =conn.createStatement();
				rs=statement.executeQuery(query);		//rs is the output of the query
				while(rs.next()){
					System.out.print(rs.getString("empid" ) + "");
					System.out.print(rs.getString("name" ) + "");
					System.out.println(rs.getString("address" ) + "");
					}
				}
			catch(Exception e) {
				System.out.println(e);
				}
			}
		//Update the data 
		public void update_name(Connection conn,String table_name,String old_name,String new_name)
		{
			Statement statement;
			try {
				String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
				statement=conn.createStatement();
				statement.executeUpdate(query);
				System.out.println("data has been updated...");
				}
			catch(Exception e) {
				System.out.println(e);
				}
			}
		
		//search by name
		public void search_by_name(Connection conn,String table_name,String name)
		{
			Statement statement;
			ResultSet rs=null;
			try {
				String query=String.format("select * from %s where name='%s'",table_name,name);
				statement=conn.createStatement();
				rs=statement.executeQuery(query);
				while(rs.next()) {
					System.out.println(rs.getString("empid"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("address"));
					}
				}
			catch(Exception e) {
				System.out.println(e);
				}
			}
		
		}
		




