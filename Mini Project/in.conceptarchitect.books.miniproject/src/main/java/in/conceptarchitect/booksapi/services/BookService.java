package in.conceptarchitect.booksapi.services;

import java.util.List;

import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.booksmodel.Review;

public interface BookService {

	List<Book> getAllBooks();

	void createBook(Book book);

	Book getBookByIsbn(String isbn);

	void updateBook(String isbn, Book book);

	void deleteBook(String isbn);

	List<Book> getBookByAuthorName(String authorName);

	List<Book> getBookByPriceRange(Integer min, Integer max);

	List<Review> getAllReviews(String isbn);
	
	

}
