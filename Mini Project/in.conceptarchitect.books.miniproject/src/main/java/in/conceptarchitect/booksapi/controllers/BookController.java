package in.conceptarchitect.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.services.BookService;


@RestController()
@RequestMapping(value="/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping("/")
	public void createBook(@RequestBody Book Book){
		bookService.createBook(Book);
	}
	
	@GetMapping("/{isbn}")
	public Book getBookByisbn(@PathVariable("isbn") String isbn){
		return bookService.getBookByIsbn(isbn);
	}
	
	@PutMapping("/{isbn}")
	public void updateBook(@PathVariable("isbn") String isbn,@RequestBody Book Book){
		bookService.updateBook(isbn,Book);
	}
	
	@DeleteMapping("/{isbn}")
	public void deleteBook(@PathVariable("isbn") String isbn){
		bookService.deleteBook(isbn);
	}

	@GetMapping("/by/{authorName}")
	public List<Book> getBookByAuthorName(@PathVariable("authorName") String authorName){
		return bookService.getBookByAuthorName(authorName);
	}
	
	@GetMapping("/price/between/{min}/and/{max}")
	public List<Book> getBookByPriceRange(@PathVariable("min") Integer min, @PathVariable("max") Integer max){
		return bookService.getBookByPriceRange(min, max);
	}
	
//	@GetMapping("/{isbn}")
//	public List<Review> getAllReviews(@PathVariable("isbn") String isbn){
//		return bookService.getAllReviews(isbn);
//	}

}
