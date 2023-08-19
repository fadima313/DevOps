package models;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="T_Administrateurs")
public class Administrateur extends Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrateur(int id, String lastname, String firstname, String login, String password) {
		super(id, lastname, firstname, login, password);
	}
	
	public Administrateur(String lastname, String firstname, String login, String password) {
		super(lastname, firstname, login, password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Administrateur)) return false;
		
		if(this.id == ((Administrateur)obj).getId())
			return true;
		
		return false;
	}

}
