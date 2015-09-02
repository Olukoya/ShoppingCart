package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_PROFILE database table.
 * 
 */
@Entity
@Table(name="USER_PROFILE", schema="TESTDB")
@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Column(name="USER_FULLNAME")
	private String userFullname;

	@Column(name="USER_PASSWORD")
	private String userPassword;

	public UserProfile() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserFullname() {
		return this.userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}