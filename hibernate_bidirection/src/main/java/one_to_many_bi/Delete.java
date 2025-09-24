package one_to_many_bi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction  et = em.getTransaction();
		
//		Bank bank = em.find(Bank.class, 2);
//		
//		List<Account> accounts = bank.getAccounts();
//		
//		et.begin();
//		for(Account a :accounts) {
//			a.setBank(null);
//			em.merge(a);
//		}
//		
//		em.remove(bank);
//		et.commit();
		
		//delete an account which is not referred 
		
//		Account a = em.find(Account.class, 106);
//		et.begin();
//		em.refresh(a);
//		et.commit();
		
		
		//deleting an account which is referenced to a bank
		
		Account a = em.find(Account.class, 101);
		Bank bank = a.getBank();
		
		et.begin();
		em.merge(bank);
		em.remove(a);
		et.commit();
		
		
		
	}
}
