package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="T_Produits")
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String name;
	private double price;
	private String description;
	private int quantity;
	

	@ManyToOne
    @JoinColumn(name = "Commande_id")
	private Commande commande = null;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande Commande) {
		this.commande = Commande;
	}

	public Produit(int id, String name, double price, String description, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
	
	public Produit(String name, double price, String description, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public String toString() {
        return "Produit [intitule=" + name + ", prix=" + price + ", description=" + description + "]";
    }
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Produit)) return false;
		
		if(this.id == ((Produit)obj).getId())
			return true;
		
		return false;
	}

}
