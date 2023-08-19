package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="T_Paiements")
public class Paiement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private double montantAPayer;
	private double remainder;
	private String Date_De_Paiement;
	

	@OneToMany(mappedBy = "paiement", cascade= {CascadeType.PERSIST})
	private List<Commande> commandes = new ArrayList<>();
	

	@ManyToOne
    @JoinColumn(name = "Recette_id")
	private Recette Recette = null;
	
	public Recette getRecette() {
		return Recette;
	}

	public void setRecette(Recette Recette) {
		this.Recette = Recette;
	}

	public Paiement(int id, double montantAPayer, double remainder, String Date_De_Paiement, List<Commande> commandes) {
		super();
		this.id = id;
		this.montantAPayer = montantAPayer;
		this.remainder = remainder;
		this.Date_De_Paiement = Date_De_Paiement;
		this.commandes = commandes;
	}
	
	public Paiement(double montantAPayer, double remainder, String Date_De_Paiement, List<Commande> commandes) {
		super();
		this.montantAPayer = montantAPayer;
		this.remainder = remainder;
		this.Date_De_Paiement = Date_De_Paiement;
		this.commandes = commandes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontantAPayer() {
		return montantAPayer;
	}

	public void setMontantAPayer(double montantAPayer) {
		this.montantAPayer = montantAPayer;
	}

	public double getRemainder() {
		return remainder;
	}

	public void setRemainder(double remainder) {
		this.remainder = remainder;
	}

	public String getDate_De_Paiement() {
		return Date_De_Paiement;
	}

	public void setDate_De_Paiement(String Date_De_Paiement) {
		this.Date_De_Paiement = Date_De_Paiement;
	}

	public List<Commande> getcommandes() {
		return commandes;
	}

	public void setcommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	public void addcommande(Commande commande) {
		commande.setPaiement(this);
		commandes.add(commande);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Paiement)) return false;
		
		if(this.id == ((Paiement)obj).getId())
			return true;
		
		return false;
	}
	

}
