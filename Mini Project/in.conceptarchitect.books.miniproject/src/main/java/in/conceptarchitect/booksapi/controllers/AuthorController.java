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

import in.conceptarchitect.booksapi.booksmodel.Author;
import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.services.AuthorService;


@RestController()
@RequestMapping(value="/api/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/")
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@PostMapping("/")
	public void createAuthor(@RequestBody Author author){
		authorService.createAuthor(author);
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable("id") Integer id){
		return authorService.getAuthorById(id);
	}
	
	@GetMapping("/{id}/books")
	public List<Book> getAllBooksByAuthor(@PathVariable("id") Integer id){
		return authorService.getAllBooksByAuthor(id);
	}
	
	@PutMapping("/{id}")
	public void updateAuthor(@PathVariable("id") Integer id,@RequestBody Author author){
		authorService.updateAuthor(id,author);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable("id") Integer id){
		authorService.deleteAuthor(id);
	}
	
	

}
