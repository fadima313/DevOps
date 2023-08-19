package tests;

import org.hibernate.Session;

import database.HibernateConnection;

public class Launch {
	
	private static TestDataBase testDataBase = new TestDataBase();
	

	public static void main(String[] args) {
		HibernateConnection hibernateConnection = HibernateConnection.getInstance();
		Session session = hibernateConnection.getSession();
		if(session.isOpen()) {
			System.out.println("Hibernate started successfully !");

			session.close();
		} else 
		System.out.println("Echec !");

	}

}
