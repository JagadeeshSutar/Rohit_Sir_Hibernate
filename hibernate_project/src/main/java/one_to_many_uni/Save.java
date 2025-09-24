package one_to_many_uni;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Account a1 = new Account();
		a1.setId(1);
		a1.setAccountName("Rohit");

		Account a2 = new Account();
		a2.setId(2);
		a2.setAccountName("Supreet");

		Account a3 = new Account();
		a3.setId(3);
		a3.setAccountName("Shuvam");
		
//		List<Account> accounts = List.of(a1,a2,a3);
		List<Account> accounts = Stream.of(a1, a2, a3)
                .collect(Collectors.toList());



		Bank b = new Bank();
		b.setId(102);
		b.setName("SBI");
		b.setAccounts(accounts);

		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(b);
		et.commit();

	}

}