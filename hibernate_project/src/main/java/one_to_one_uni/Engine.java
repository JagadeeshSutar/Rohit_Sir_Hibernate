package one_to_one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	
	@Id
	private int id;
	private String engineType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", engineType=" + engineType + ", getId()=" + getId() + ", getEngineType()="
				+ getEngineType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
