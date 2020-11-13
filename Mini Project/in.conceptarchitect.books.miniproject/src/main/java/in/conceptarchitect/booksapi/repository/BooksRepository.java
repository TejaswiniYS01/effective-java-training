package in.conceptarchitect.booksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.conceptarchitect.booksapi.booksmodel.Book;

public interface BooksRepository extends JpaRepository<Book,String>{

	Book findByIsbn(String isbn);
	
	List<Book> findByAuthorName(String authorName);
	
	List<Book> findByPriceBetween(int min, int max);
}
