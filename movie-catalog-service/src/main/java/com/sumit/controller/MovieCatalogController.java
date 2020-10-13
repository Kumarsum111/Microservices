package com.sumit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.sumit.model.CatalogItem;
import com.sumit.model.UserRating;
import com.sumit.service.MovieInfo;
import com.sumit.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = userRatingInfo.getUserRating(userId);

		return userRating.getRatings().stream().map(rating -> {
			return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}

}

//WebClient is used to have Asynchonous calls so that application can do other
// works will it is getting executed

// Movie movie =
// webClientBuilder.build().get().uri("http://localhost:8082/movies/" +
// rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
