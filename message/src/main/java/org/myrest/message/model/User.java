package org.myrest.message.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.myrest.message.constraints.UserValid;


@XmlRootElement
@Entity
@Table(name="new_table")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int user_id;
	@Transient
	private String status;
	@Transient
	private String token;
	
	
	@Column(name="user_fname")
	@NotNull
	@NotEmpty(message="First name can't be empty")
	private String user_fname;
	

	@Column(name="user_lname")
	@NotNull
	@NotEmpty
	private String user_lname;
	
	
	@Column(name="user_password")
	@NotNull
	@Size(min=6,message="Password size must be 6 to 10 chars")
	private String password;
	
	
	@Column(name="user_email",unique=true)
	@NotNull
	@Email
	private String user_email;
	

	
	public User() {
		
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_fname() {
		return user_fname;
	}
	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}
	public String getUser_lname() {
		return user_lname;
	}
	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", status=" + status + ", token=" + token + ", user_fname=" + user_fname
				+ ", user_lname=" + user_lname + ", user_email=" + user_email + "]";
	}
	
}
