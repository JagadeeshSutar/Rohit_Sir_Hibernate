package many_to_one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	private int id;
	private String feedbaback;
	
	@ManyToOne
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedbaback() {
		return feedbaback;
	}

	public void setFeedbaback(String feedbaback) {
		this.feedbaback = feedbaback;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", feedbaback=" + feedbaback + ", product=" + product + ", getId()=" + getId()
				+ ", getFeedbaback()=" + getFeedbaback() + ", getProduct()=" + getProduct() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
