package com.sumit.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.model.Rating;
import com.sumit.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	 @RequestMapping("/user/{userId}")
	    public UserRating getUserRatings(@PathVariable("userId") String userId) {
	        UserRating userRating = new UserRating();
	        userRating.initData(userId);
	        return userRating;

	    }
}
