package in.conceptarchitect.booksapi.services;

import java.util.List;
import in.conceptarchitect.booksapi.booksmodel.Author;
import in.conceptarchitect.booksapi.booksmodel.Book;

public interface AuthorService {

	public List<Author> getAllAuthors();

	public Object createAuthor(Author author);

	public Author getAuthorById(Integer id);

	public List<Book> getAllBooksByAuthor(Integer id);

	public void updateAuthor(Integer id, Author author);

	public void deleteAuthor(Integer id);
}
