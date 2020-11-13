package in.conceptarchitect.booksapi.booksmodel;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Entity //this object should be saved in a database
@Table(name="books")
public class Book {

	@Id //primary key
	String isbn;
	String title;
	Integer price;
	@OneToOne
	@JoinColumn(name="author")
	Author author;
	String description;
	String tag;
	String cover;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
//	public List<Review> getReviews() {
//		return reviews;
//	}
//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}
	public Book(String isbn, String title, Author author, String description, String tag, String cover,
			List<Review> reviews) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.tag = tag;
		this.cover = cover;
		//this.reviews = reviews;
	}
	public Book() {
		super();
	}
	
}
