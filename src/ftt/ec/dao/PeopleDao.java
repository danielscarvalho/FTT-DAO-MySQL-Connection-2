package ftt.ec.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ftt.ec.model.People;
import ftt.ec.util.DbUtil;

public class PeopleDao implements Dao {
	
	private Connection connection;
	
	//Construtor
	public PeopleDao() {
		
		try {
			this.connection = DbUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} //PeopleDao

	public void addPeople(People people) {
		
		try {

		String sql = "INSERT INTO FTT.PEOPLE (NAME, EMAIL, DOB, COLOR, CARDTYPE, " 
				+ "GENDER, PERIOD, VALUE) VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = this.connection
				.prepareStatement(sql);
		
		preparedStatement.setString(1, people.getName());
		preparedStatement.setString(2, people.getEmail());
		//java.util.Date() tem timezone, java.sql.Date() não tem timezone
		preparedStatement.setDate(3, new java.sql.Date(people.getDob().getTime()));
		preparedStatement.setString(4, people.getColor());
		preparedStatement.setString(5, people.getCardType());
		preparedStatement.setString(6, people.getGender());
		preparedStatement.setString(7, people.getPeriod());
		preparedStatement.setFloat(8, people.getValue());
		
		preparedStatement.executeUpdate();
		
		} catch(Exception e){
			e.printStackTrace();
		} //try
		
	} //addPeople
	
	public void deletePeople(People people) {
		
		this.deletePeople(people.getId());
	
	} //deletePeople
	
	public void deletePeople(long id) {
		
		String sql = "DELETE FROM FTT.PEOPLE WHERE ID=?";
		
		try {
			
			PreparedStatement preparedStatement = this.connection
					.prepareStatement(sql);
			
			preparedStatement.setLong(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	} //deletePeople
	
	public void updatePeople(People people) {
		
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE USERS SET NAME=?, " 
                    		                          + "EMAIL=?, " 
                    		                          + "DOB=?, " 
                    		                          + "COLOR=?, " 
                    		                          + "CARDTYPE=?, " 
                    		                          + "GENDER=?, " 
                    		                          + "PERIOD=? " 
                    		                          + "VALUE=? " 
                                               + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getEmail());
            preparedStatement.setDate(3, (java.sql.Date)people.getDob());
            preparedStatement.setString(4, people.getColor());
            preparedStatement.setString(5, people.getCardType());
            preparedStatement.setString(6, people.getGender());
            preparedStatement.setString(7, people.getPeriod());
            preparedStatement.setFloat(8, people.getValue());
            
            preparedStatement.setLong(9, people.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	//Generics
	public List<People> getAllPeople() {
		
		List<People> p = new ArrayList<People>();
		
		try {
			
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE");
            
            while (rs.next()) {
                
            	People people = new People();
                
            	people.setId(rs.getInt("ID"));
                people.setName(rs.getString("NAME"));
                people.setEmail(rs.getString("EMAIL"));
                people.setDob(rs.getDate("DOB"));
                people.setValue(rs.getFloat("VALUE"));
                people.setValue(rs.getString("COLOR"));
                people.setValue(rs.getString("CARDTYPE"));
                people.setValue(rs.getString("GENDER"));
                people.setValue(rs.getString("PERIOD"));

                p.add(people);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
		return p;
	}
	
	public People getUserById(int id) {
		
		People p = new People();
		
		try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from PEOPLE WHERE ID=?");
            
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                p.setEmail(rs.getString("EMAIL"));
                p.setDob(rs.getDate("DOB"));
                p.setValue(rs.getFloat("VALUE"));
                p.setColor(rs.getString("COLOR"));
                p.setColor(rs.getString("CARD"));
                p.setColor(rs.getString("PERIOD"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return p;
	}

	public People getUserById(People p) {
		
		return this.getUserById(p.getId());

	}

} //PeopleDao
