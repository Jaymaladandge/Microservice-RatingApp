package com.rating.service;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getAll();
	
	Rating getRating(int ratingId);
	
	void deleteRating(int ratingId);
	
	
	void updateRating(Rating rating);
	
	Rating updateRating(Rating rating, int ratingId);
	
	List<Rating> getRatingByUserId(int userId);
	
	List<Rating> getRatingByHotlId(int hotelId);
	
}
