package in.conceptarchitect.booksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.conceptarchitect.booksapi.booksmodel.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{

	Author findById(int id);
	
	void deleteById(int id);
}
