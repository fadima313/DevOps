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

@Entity(name="T_Commandes")
public class Commande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@OneToMany(mappedBy = "commande", cascade= {CascadeType.PERSIST})
	private List<Produit> produits = new ArrayList<>();
	
    private String hourCommande;
    private double totalPrice;

	@ManyToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement = null;
    
	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public Commande(int id, List<Produit> produits, String hourCommande, double totalPrice) {
		super();
		this.id = id;
		this.produits = produits;
		this.hourCommande = hourCommande;
		this.totalPrice = totalPrice;
	}
	
	public Commande(List<Produit> produits, String hourCommande, double totalPrice) {
		super();
		this.produits = produits;
		this.hourCommande = hourCommande;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getHourCommande() {
		return hourCommande;
	}

	public void setHourCommande(String hourCommande) {
		this.hourCommande = hourCommande;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void addProduit(Produit produit) {
		produit.setCommande(this);
		produits.add(produit);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Commande)) return false;
		
		if(this.id == ((Commande)obj).getId())
			return true;
		
		return false;
	}
    
}
