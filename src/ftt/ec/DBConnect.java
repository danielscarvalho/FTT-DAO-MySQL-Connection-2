package ftt.ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import ftt.ec.dao.PeopleDao;
import ftt.ec.model.People;

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
		
		People p1 = new People();
		People p2 = new People();
		
		p1.setName("João");		
		p2.setName("Maria");
		
		System.out.println(p1);
		System.out.println(p2);
		
		
		//Dao teste!!!
		
		PeopleDao peopleDao = new PeopleDao();
		
		People pDell = new People();
		pDell.setId(700);
		
		peopleDao.deletePeople(800);
		peopleDao.deletePeople(pDell);
		
		
		
	} //main
	
} //DBConnect
