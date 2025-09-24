package many_to_many_uni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ManyStudent {
	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<ManySubject> subjects;
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
	public List<ManySubject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<ManySubject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subjects=" + subjects + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSubjects()=" + getSubjects() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
