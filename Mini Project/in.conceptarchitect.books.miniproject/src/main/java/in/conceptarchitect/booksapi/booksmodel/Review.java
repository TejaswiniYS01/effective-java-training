package in.conceptarchitect.booksapi.booksmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //this object should be saved in a database
@Table(name="review")
public class Review {

	@Id
	int id;
	@ManyToOne
	@JoinColumn(name="book")
	Book book;
	String reviewer;
	String review;
	int rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Review(int id, Book book, String reviewer, String review, int rating) {
		super();
		this.id = id;
		this.book = book;
		this.reviewer = reviewer;
		this.review = review;
		this.rating = rating;
	}
	public Review() {
		super();
	}
	
	
	
	
	

}
