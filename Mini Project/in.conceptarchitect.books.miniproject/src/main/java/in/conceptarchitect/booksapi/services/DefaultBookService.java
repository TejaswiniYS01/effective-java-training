package in.conceptarchitect.booksapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.booksmodel.Review;
import in.conceptarchitect.booksapi.repository.BooksRepository;

@Service
public class DefaultBookService implements BookService {
	
	@Autowired
	BooksRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
		List<Book> books =  bookRepo.findAll();
		return books;
	}

	@Override
	public void createBook(Book book) {
		 bookRepo.save(book);
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return bookRepo.findByIsbn(isbn);
	}

	@Override
	public void updateBook(String isbn, Book book) {
		Book existing = bookRepo.findByIsbn(isbn);
		if(existing!=null) {
			BeanUtils.copyProperties(book, existing);
			existing.setIsbn(isbn);
			bookRepo.save(existing);
		}
	}

	@Override
	public void deleteBook(String isbn) {
		Book existing = bookRepo.findByIsbn(isbn);
		bookRepo.delete(existing);
		
	}

	
	@Override
	public List<Book> getBookByAuthorName(String authorName) {
		return bookRepo.findByAuthorName(authorName);
	}

	@Override
	public List<Book> getBookByPriceRange(Integer min, Integer max) {
		return bookRepo.findByPriceBetween(min, max);
	}

	@Override
	public List<Review> getAllReviews(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
