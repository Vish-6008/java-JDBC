package J4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class T1_insert {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/tut_db", "postgres", "Vishwa123");
            
            // Create the table if it doesn't exist
            createTable(con);

            PreparedStatement pstm = con.prepareStatement("INSERT INTO emp(emp_id, emp_name, emp_salary, emp_location) VALUES (?, ?, ?, ?)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter emp ID:");
                int eno = Integer.parseInt(br.readLine());

                System.out.println("Enter emp NAME:");
                String ename = br.readLine();

                System.out.println("Enter emp SALARY:");
                double esal = Double.parseDouble(br.readLine());
                
                System.out.println("Enter emp LOCATION:");
                String eplace = br.readLine();

                pstm.setInt(1, eno);
                pstm.setString(2, ename);
                pstm.setDouble(3, esal);
                pstm.setString(4, eplace);

                int count = pstm.executeUpdate();
                if (count > 0) {
                    System.out.println(count + " record(s) inserted.");
                } else {
                    System.out.println("Not inserted...");
                }

                System.out.println("Do you want to add more records [yes/no]");

                String ch = br.readLine();
                if (!ch.equalsIgnoreCase("yes")) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static void createTable(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS emp (" +
                                "emp_id SERIAL PRIMARY KEY, "+
                                "emp_name VARCHAR(255), " +
                                "emp_salary DOUBLE PRECISION, " +
                                "emp_location VARCHAR(255)" +
                                ")";
        
        System.out.println(createTableSQL);
        
        try (PreparedStatement statement = con.prepareStatement(createTableSQL)) {
            statement.execute();
            System.out.println("Table created successfully.");
        }
    }
}

       