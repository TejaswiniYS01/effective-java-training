package in.conceptarchitect.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.booksapi.booksmodel.Review;
import in.conceptarchitect.booksapi.services.ReviewService;

@RestController()
@RequestMapping(value="/api/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/")
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	@PostMapping("/{isbn}")
	public void addReview(@PathVariable String isbn,@RequestBody Review review){
		reviewService.addReview(isbn,review);
	}
	
	@GetMapping("/{isbn}")
	public List<Review> getReviewsByIsbn(@PathVariable String isbn){
		return reviewService.getReviewsByIsbn(isbn);
	}
	
	@GetMapping("/rating-between/{min}/and/{max}")
	public List<Review> getRatingBetweenRange(@PathVariable Integer min, @PathVariable Integer max){
		return reviewService.getRatingBetweenRange(min,max);
	}
	
	@GetMapping("/{isbn}/average-rating")
	public Double getAverageRating(@PathVariable String isbn){
		return reviewService.getAverageRating(isbn);
	}
	
	@GetMapping("/containing/{text}")
	public List<Review> getReviewContainingText(@PathVariable String text){
		return reviewService.getReviewContainingText(text);
	}

}
