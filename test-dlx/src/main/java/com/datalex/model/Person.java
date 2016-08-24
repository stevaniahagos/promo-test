package com.datalex.model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

public class Person {
	
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String birthDate;
	private int age;
	private HashMap<String, String> contactInfos;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(String birthDate) throws ParseException{
		this.age = computeAge(birthDate);
	}
	
	public void addContact(String type, String content){
		this.getContactInfos().put(type, content);
	}
	
	public HashMap<String, String> getContactInfos() {
		return contactInfos;
	}
	
	public void setContactInfos(HashMap<String, String> contactInfos) {
		this.contactInfos = contactInfos;
	}
	
	/**
	 * Computes person's age based on entered string
	 * @param String birthDate - format mm/dd/yyyy
	 * @return person's age in years
	 * @throws ParseException
	 */
	public int computeAge(String birthDate) throws ParseException{
		Calendar bday = new GregorianCalendar(Locale.GERMAN);

		String[] nos = birthDate.split("/");
		
		//subtracting 1 from input date because java.util.Calendar.MONTH is zero-based
		bday.set(Calendar.MONTH, Integer.parseInt(nos[0]) - 1);
		bday.set(Calendar.DATE, Integer.parseInt(nos[1]));
		bday.set(Calendar.YEAR, Integer.parseInt(nos[2]));

		Calendar now = new GregorianCalendar(Locale.GERMAN);
		int personAge = 0;
		
		if(bday.get(Calendar.DAY_OF_YEAR) >= now.get(Calendar.DAY_OF_YEAR)){			
			personAge = now.get(Calendar.YEAR) - bday.get(Calendar.YEAR) - 1;
		} else if(bday.get(Calendar.DAY_OF_YEAR) < now.get(Calendar.DAY_OF_YEAR)){			
			personAge = now.get(Calendar.YEAR) - bday.get(Calendar.YEAR); 
		}
		
		return personAge;
	}

}
