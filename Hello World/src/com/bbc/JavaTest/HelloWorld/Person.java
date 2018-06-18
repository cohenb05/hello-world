package com.bbc.JavaTest.HelloWorld;


public class Person {
	
	 private int id = 0;
	 private String firstName = null;
	 private String lastName = null;
	
	
//	public Person(String firstName, String lastName) {		  	
//		 this.id = 0;	
//		 this.firstName = firstName;            
//		 this.lastName = lastName;	
//		}
	 
	public int getId() {
	        return id;
	    }
	 
	 public String getFirstName() {
	        return firstName;
	    }

	 public String getLastName() {
	        return lastName;
	    }


	 public void setId(int value) {
	        this.id = value;
	    }
	 
	 public void setFirstName(String value) {
	        this.firstName = value;
	    }
	 
	 public void setLastName(String value) {
	        this.lastName = value;
	    }

}
