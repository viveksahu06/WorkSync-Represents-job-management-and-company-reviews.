package com.jobapp.reviewms.review;

import com.jobapp.reviewms.review.messaging.ReviewMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewMessageProducer reviewMessageProducer;
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }
    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,@RequestBody Review review){
        boolean isAdded=reviewService.addReview(companyId,review);
        if(isAdded){
            reviewMessageProducer.sendMessage(review);
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review){
        boolean isUpdated= reviewService.updateReview(reviewId,review);

        if(isUpdated)
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isDeleted= reviewService.deleteReview(reviewId);

        if(isDeleted)
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/averageRating")
    public Double getAverageReview( @RequestParam  Long companyId){
        List<Review>reviewList=reviewService.getAllReviews(companyId);
        return reviewList.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }
}
