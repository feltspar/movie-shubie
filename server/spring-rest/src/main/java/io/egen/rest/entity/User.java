package io.egen.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.firstName ASC") ,
		@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.email = :pEmail")
})
public class User {

	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String userId;
	
	@Column(unique =true)
	private String email;
	private String passWord;
	
	private String firstName;
	private String lastName;
	
	private String displayPicUrl;
	//Age
	//Gender
	//List<MovieID> seen
	//List<MovieID> wish_list. 

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

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

	public String getDisplayPicUrl() {
		return displayPicUrl;
	}

	public void setDisplayPicUrl(String displayPicUrl) {
		this.displayPicUrl = displayPicUrl;
	}

	@Override 
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", displayPicUrl=" + displayPicUrl + "]";
	}
	
}



/*
{   "email": "shubham.s.saxena@gmail.com",
	"passWord": "password!@#",
	
	"firstName": "Shubham",
	"lastName": "Saxena",
	
	"displayPicUrl": "https://scontent-lga3-1.xx.fbcdn.net/t31.0-8/13243932_10157086561025724_8486387441675609128_o.jpg"
}*/