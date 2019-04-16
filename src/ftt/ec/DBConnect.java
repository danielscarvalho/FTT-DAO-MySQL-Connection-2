package ftt.ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* Start MySQL Linux: service mysql start
 * 
 * 
 * 
 * Reference: https://dev.mysql.com/doc/connector-j/5.1/en/
 * Reference: http://www.benchresources.net/jdbc-driver-list-and-url-for-all-databases/
 */

public class DBConnect {

	public static void main (String args[]) {
		
		System.out.println("DBConnect...");
		
		//String de conexão com banco de dados MySQL
		
		              //jdbc:mysql://localhost:3306/dbname
		String dburl = "jdbc:mysql://localhost:3306/FTT";
		
		String user="scott";
		String pwd="tiger";
		
		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(dburl, user, pwd);
		
			String query = "SELECT COUNT(1) QTD FROM FTT.PEOPLE;";
			
			Statement st = connection.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			
			System.out.println("QTD: " + rs.getString("QTD"));
						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //try
		
		
		
	} //main
	
} //DBConnect
