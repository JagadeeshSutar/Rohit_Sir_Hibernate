
package one_to_many_uni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<Account> accounts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", accounts=" + accounts + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAccounts()=" + getAccounts() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
