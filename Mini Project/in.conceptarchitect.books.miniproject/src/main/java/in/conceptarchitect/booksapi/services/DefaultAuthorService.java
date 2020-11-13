package in.conceptarchitect.booksapi.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.conceptarchitect.booksapi.booksmodel.Author;
import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.repository.AuthorRepository;

@Service
public class DefaultAuthorService implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepo;

	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Override
	public Object createAuthor(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public Author getAuthorById(Integer id) {
		return authorRepo.findById(id).get();
	}

	@Override
	public List<Book> getAllBooksByAuthor(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAuthor(Integer id, Author author) {
		Author existing = authorRepo.findById(id).get();
		if(existing!=null) {
			BeanUtils.copyProperties(author, existing);
			existing.setId(id);
			authorRepo.save(existing);
		}
	}

	@Override
	public void deleteAuthor(Integer id) {
		// TODO Auto-generated method stub
		Author existing = authorRepo.findById(id).get();
		authorRepo.delete(existing);
	}

}
