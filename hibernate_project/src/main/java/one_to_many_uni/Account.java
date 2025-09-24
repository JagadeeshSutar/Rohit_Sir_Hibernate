

package one_to_many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", getId()=" + getId() + ", getAccountName()="
				+ getAccountName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	@Id
	private int id;
	private String accountName;
	
}
