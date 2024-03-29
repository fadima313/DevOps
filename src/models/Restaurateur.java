package models;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="T_Restaurateurs")
public class Restaurateur extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Restaurateur(int id, String lastname, String firstname, String login, String password) {
		super(id, lastname, firstname, login, password);
	}

	
	public Restaurateur(String lastname, String firstname, String login, String password) {
		super(lastname, firstname, login, password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Restaurateur)) return false;
		
		if(this.id == ((Restaurateur)obj).getId())
			return true;
		
		return false;
	}

}
