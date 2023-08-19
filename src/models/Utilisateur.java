package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="T_Utilisateurs")
public class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	protected String lastname;
	protected String firstname;
	protected String login;
	protected String password;
	
	public Utilisateur(int id, String lastname, String firstname, String login, String password) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur(String lastname, String firstname, String login, String password) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Utilisateur)) return false;
		
		if(this.id == ((Utilisateur)obj).getId())
			return true;
		
		return false;
	}
	
}
