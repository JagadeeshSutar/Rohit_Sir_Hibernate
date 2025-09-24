package one_to_many_bi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Bank bank = em.find(Bank.class, 1);
		System.out.println(bank.getId());
		
		List<Account> accounts = bank.getAccounts();
		
		for(Account a : accounts) {
			System.out.println(a.getId());
		}
	}
}
