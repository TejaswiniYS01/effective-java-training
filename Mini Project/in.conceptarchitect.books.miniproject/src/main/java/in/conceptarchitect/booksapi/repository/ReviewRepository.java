package in.conceptarchitect.booksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.conceptarchitect.booksapi.booksmodel.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer>{
	
	List<Review> findByBookIsbn(String isbn);
	
	List<Review> findByRatingBetween(Integer min, Integer max);
	
	@Query(value = "SELECT avg(rating) FROM review left join books on review.book=books.isbn where review.book=:isbn",nativeQuery=true)
	public Double findAvgRating(@Param(value="isbn") String isbn);
	
	//Double findByBookIsbnAverageRating(String isbn);

	List<Review> findByReviewContainingIgnoreCase(String review);
}
