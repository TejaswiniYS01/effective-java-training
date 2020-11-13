package in.conceptarchitect.booksapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.booksmodel.Review;
import in.conceptarchitect.booksapi.repository.BooksRepository;
import in.conceptarchitect.booksapi.repository.ReviewRepository;

@Service
public class DefaultReviewService implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired 
	BooksRepository bookRepo;

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public void addReview(String isbn,Review review) {
		Book book = bookRepo.findByIsbn(isbn);
		review.setBook(book);
		reviewRepository.save(review);
	}

	@Override
	public List<Review> getReviewsByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return reviewRepository.findByBookIsbn(isbn);
	}

	@Override
	public List<Review> getRatingBetweenRange(Integer min, Integer max) {
		// TODO Auto-generated method stub
		return reviewRepository.findByRatingBetween(min,max);
	}

	@Override
	public Double getAverageRating(String isbn) {
		// TODO Auto-generated method stub
		return reviewRepository.findAvgRating(isbn);
	}

	@Override
	public List<Review> getReviewContainingText(String text) {
		// TODO Auto-generated method stub
		return reviewRepository.findByReviewContainingIgnoreCase(text);
	}

}
