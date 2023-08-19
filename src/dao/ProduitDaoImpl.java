package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import database.HibernateConnection;
import models.Produit;
import exception.DAOException;
//import dao.IDao;


public class ProduitDaoImpl implements IDao<Produit> {

	@Override
	public void create(Produit entity) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			
			session.persist(entity);
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@Override
	public Produit read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Produit produit = null;
		try {
			Session session = HibernateConnection.getInstance().getSession();
			produit = session.find(Produit.class, id);
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return produit;
	}

	@Override
	public List<Produit> list() throws DAOException {
		// TODO Auto-generated method stub
		List<Produit> produits = new ArrayList<>();
		try {
			Session session = HibernateConnection.getInstance().getSession();

			
			Query<Produit> query = session.createQuery("From T_Produits");
			produits = query.getResultList();
			//HibernateConnection.getInstance().closeSession();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return produits;
	}

	@Override
	public void update(Produit entity) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			session.update(entity);
			transaction.commit();
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			
			Produit produit = read(id);
			if(produit != null) {
				session.delete(produit);
			}
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

}
