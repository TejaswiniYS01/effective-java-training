package in.conceptarchitect.booksapi.booksmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity //this object should be saved in a database
@Table(name="author")
public class Author {

	@Id //primary key
	int id;
	String name;
	String biography;
	//String books ;
	String photograph;
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"))
//	List<Book> bookList = new ArrayList<>();
	
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
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getPhotograph() {
		return photograph;
	}
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
//	public List<Book> getBooks() {
//		return bookList;
//	}
//	public void setBooks(List<Book> books) {
//		this.bookList = books;
//	}
	public Author(int id, String name, String biography, String photograph) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.photograph = photograph;
	}
	public Author() {
		super();
	}
	
	
}
