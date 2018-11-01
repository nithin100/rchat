package com.rsrit.rchat.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/*
 *Entity to store user details 
 * 
 */

@Entity
public class RchatUser implements Serializable {

	private static final long serialVersionUID = -7739966869156526004L;

	@Id
	@GeneratedValue
	private int user_id;

	private String firstName;

	private String lastName;

	private String email;

	private String userName;

	private String gender;

	@JsonProperty(access = Access.WRITE_ONLY)
	private int isActive;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String mobile;
	
	
	/*@OneToOne
	private RchatContacts contactsBook;*/

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public RchatUser(String firstName, String lastName, String email, String userName, String gender, int isActive,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.gender = gender;
		this.isActive = 1;
		this.password = password;
	}

	public RchatUser() {

	}

}
