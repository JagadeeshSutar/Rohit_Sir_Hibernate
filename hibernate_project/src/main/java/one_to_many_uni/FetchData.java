package one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchData {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		

		//finding which bank the acccount belong to 
		Query query = em.createQuery("select b from Bank b JOIN b.accounts acc where acc.id = :accId");
		
		query.setParameter("accId", 1);
		Bank b = (Bank) query.getSingleResult();
		System.out.println(b);
	}
}
