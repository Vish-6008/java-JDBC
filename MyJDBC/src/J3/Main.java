package J3;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		DbFunction db=new DbFunction();
		Connection conn=db.connect_to_db("tut_db", "postgres", "Vishwa123"); 
		//db.createTable(conn,"companye");
		
		//db.insert_row(conn,"companye","vishwa","india");
		// TODO Auto-generated method stub
		//db.insert_row(conn,"companye","spoorthi","malaysia");
		
		db.update_name(conn,"companye","veena","spoorthi");
		db.read_data(conn,"companye");
		
		//db.search_by_name(conn, "companye","vishwa");
	}

}
