package fetchtypes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	private int id;
	private String feedback;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
