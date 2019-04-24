package ftt.ec.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

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
		preparedStatement.setString(5, people.getCardtype());
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
		
	}
	
	//Generics
	public List<People> getAllPeople() {
		
		List<People> p = new ArrayList<People>();
		
		//...
		
		return p;
	}
	
	public People getUserById(long id) {
		People p = new People();
		//...
		return p;
	}

	public People getUserById(People p) {
		//...
		
		return p;
	}

} //PeopleDao
