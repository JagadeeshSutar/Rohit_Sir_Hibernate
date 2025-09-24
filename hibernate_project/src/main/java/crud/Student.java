package crud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int id;
	private String namee;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamee() {
		return namee;
	}
	public void setNamee(String namee) {
		this.namee = namee;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", namee=" + namee + ", age=" + age + ", getId()=" + getId() + ", getNamee()="
				+ getNamee() + ", getAge()=" + getAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
