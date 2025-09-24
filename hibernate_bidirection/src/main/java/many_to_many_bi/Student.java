package many_to_many_bi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	@JoinTable(joinColumns = @JoinColumn(name="stu_id"),inverseJoinColumns = @JoinColumn(name="sub"))
	@ManyToMany
	private List<Subject> subjects;
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
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subjects=" + subjects + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSubjects()=" + getSubjects() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
