package one_to_one_bidirection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {
	@Id
	private int id;
	private String name;
	@JoinColumn
	@OneToOne
	private Engine engine;
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
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", engine=" + engine + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getEngine()=" + getEngine() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
