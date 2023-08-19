package tests;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.*;
import exception.DAOException;
import database.*;
import models.*;
import factories.*;


public class TestDataBase {



	
		public TestDataBase() {}

		public Administrateur creerAdministrateur() throws DAOException {
			AdministrateurDaoImpl adminDao = ConcreteFactory.getFactory(AdministrateurFactory.class)
					.getAdministrateurDao(AdministrateurDaoImpl.class);
			Administrateur admin = null;
			
			admin = new Administrateur("AdminLN", "AdminFN", "adminLogin", "adminPassword");
			adminDao.create(admin);
			System.out.println("Une nouvelle admin est ajouté !");
			
			return admin;
		}
		
		public Chef creerChef() throws DAOException {
			ChefDaoImpl chefDao = ConcreteFactory.getFactory(ChefFactory.class)
					.getChefDao(ChefDaoImpl.class);
			Chef chef = null;
			
			chef = new Chef("ChefLN", "ChefFN", "chefLogin", "chefPassword");
			chefDao.create(chef);
			System.out.println("Un nouveau chef est ajouté !");
			
			return chef;
		}
		
		public Restaurateur creerRestaurateur() throws DAOException {
			RestaurateurDaoImpl restaurateurDao = ConcreteFactory.getFactory(RestaurateurFactory.class)
					.getRestaurateurDao(RestaurateurDaoImpl.class);
			Restaurateur restaurateur = null;
			
			restaurateur = new Restaurateur("RestaurateurLN", "RestaurateurFN", "restaurateurLogin", "restaurateurPassword");
			restaurateurDao.create(restaurateur);
			System.out.println("Un nouveau restaurateur est ajouté !");
			
			return restaurateur;
		}
		
		public Produit creerProduit(int id, String name, double price, String description, int quantity) throws DAOException {
			ProduitDaoImpl ProduitDao = ConcreteFactory.getFactory(ProduitFactory.class)
					.getProduitDao(ProduitDaoImpl.class);
			Produit Produit = null;
			
			Produit = new Produit(id, name, price, description, quantity);
			ProduitDao.create(Produit);
			System.out.println("Un nouveau produit est ajouté !");
			
			return Produit;
		}
		
		public Commande creerCommande(List<Produit> Produits) throws DAOException {
			CommandeDaoImpl CommandeDao = ConcreteFactory.getFactory(CommandeFactory.class)
					.getCommandeDao(CommandeDaoImpl.class);
			Commande Commande = null;
			
			double totalPrice = 0;
			for(Produit Produit : Produits) {
				totalPrice += Produit.getPrice();
			}
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dateString = sdf.format(date);
			
			Commande = new Commande(Produits, dateString, totalPrice);
			CommandeDao.create(Commande);
			System.out.println("Une nouvelle commande est ajoutée !");
			
			return Commande;
		}
		
		public Paiement creerPaiement(int id, double  montantPaye, double remainder, String Date_De_Paiement, List<Commande> commandes) throws DAOException {
			PaiementDaoImpl paiementDao = ConcreteFactory.getFactory(PaiementFactory.class)
					.getPaiementDao(PaiementDaoImpl.class);
			Paiement paiement = null;
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dateString = sdf.format(date);
			
			paiement = new Paiement(id, montantPaye, remainder, Date_De_Paiement, commandes);
			paiementDao.create(paiement);
			System.out.println("Une nouvelle commande est ajoutée !");
			
			return paiement;
		}

		
		public Recette  creerRecette (int id, List<Paiement> paiements) throws DAOException {
			RecetteDaoImpl RecetteDao = ConcreteFactory.getFactory(RecetteFactory.class)
					.getRecetteDao(RecetteDaoImpl.class);
			Recette  Recette  = null;
			
			Recette  = new Recette (id, paiements);
			
			for(Paiement pay : paiements) 
				Recette.addPaiement(pay);
			
			RecetteDao.create(Recette );
			System.out.println("Une nouvelle recette est ajoutée !");
			
			return Recette ;
		}
		
		public Recette  creerRecette (Recette  Recette ) throws DAOException {
			RecetteDaoImpl RecetteDao = ConcreteFactory.getFactory(RecetteFactory.class)
					.getRecetteDao(RecetteDaoImpl.class);
			RecetteDao.create(Recette );
			System.out.println("Une nouvelle recette est ajoutée !");
			
			return Recette ;
		}
	}