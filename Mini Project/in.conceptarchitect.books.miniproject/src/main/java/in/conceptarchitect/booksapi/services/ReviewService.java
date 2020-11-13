package in.conceptarchitect.booksapi.services;

import java.util.List;

import in.conceptarchitect.booksapi.booksmodel.Review;

public interface ReviewService {

	List<Review> getAllReviews();

	void addReview(String isbn,Review review);

	List<Review> getReviewsByIsbn(String isbn);

	List<Review> getRatingBetweenRange(Integer min, Integer max);

	Double getAverageRating(String isbn);

	List<Review> getReviewContainingText(String text);

	
}
