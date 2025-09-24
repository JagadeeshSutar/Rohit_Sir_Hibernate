package one_to_many_bi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		
		Bank bank = new Bank();
		bank.setId(2);
		bank.setName("SBI");
		
		Account a4 = new Account();
		a4.setId(104);
		a4.setName("Shyam");
		a4.setBank(bank);
		
		Account a5 = new Account();
		a5.setId(105);
		a5.setName("Suprit");
		a5.setBank(bank);
		
		Account a6 = new Account();
		a6.setId(106);
		a6.setName("Pritam");
		a6.setBank(bank);
		
		List<Account> accounts = new ArrayList<>();
		Collections.addAll(accounts, a4, a5, a6);
		
		bank.setAccounts(accounts);
		
		et.begin();
		em.persist(a6);
		em.persist(a5);
		em.persist(a4);
		em.persist(bank);
		et.commit();
		
		
	}
}
