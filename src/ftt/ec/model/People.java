package ftt.ec.model;

import java.text.SimpleDateFormat;

//POJO - JavaBean

import java.util.Date;

public class People {

	private int id;
	private String name;
	private String email;
	private Date dob;
	private String color;
	private String cardtype;
	private String gender;
	private String period;
	private float value;

	//Construtor default
	public People() {
		super();
	}
	
	public People(String id, String name, String email, String dob, String color, String cardtype, String gender,
			String period, String value) {
		
		super();
		
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setDob(dob);
		this.setColor(color);
		this.setCardtype(cardtype);
		this.setGender(gender);
		this.setPeriod(period);
		this.setValue(value);
	}
	
	public People(int id, String name, String email, Date dob, String color, String cardtype, String gender,
			String period, float value) {
		
		super();
		
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setDob(dob);
		this.setColor(color);
		this.setCardtype(cardtype);
		this.setGender(gender);
		this.setPeriod(period);
		this.setValue(value);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			this.dob = formatter.parse(dob);
		
		} catch(Exception e) {
			System.err.println("Ops! Data zuada! " + dob);
			e.printStackTrace();
		}
		
		//this.dob = dob;
	
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public float getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = Float.valueOf(value);
	}
	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "People ["
				+ "id=" + this.getId()
				+ ",name=" + this.getName()
				+ ",email=" + this.getEmail()
				+ ",dob=" + this.getDob()
				
				//TODO: Terminar
				
				+ "]";
		
	} //toString
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof People) {
			return (this.getId() == ((People) obj).getId());
		} else {
			return false;
		}
	} //equals
	
	
} //People
