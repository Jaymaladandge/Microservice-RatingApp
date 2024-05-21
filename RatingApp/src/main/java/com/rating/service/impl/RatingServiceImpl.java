package com.rating.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rating.entities.Rating;
import com.rating.exceptions.ResourceNotFoundException;
import com.rating.repositories.RatingRepository;
import com.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingRepo.findAll();
	}

	@Override
	public Rating getRating(int ratingId) {
		return ratingRepo.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating not found with id : " + ratingId));
	}

	@Override
	public void updateRating(Rating rating) {
		logger.info("=====================RatingServiceImpl updateRating===================="+rating);
		Optional<Rating> optRating = ratingRepo.findById(rating.getRatingId());

		optRating.ifPresent(rating1 -> {
			rating1.setFeedback(rating.getFeedback());
			rating1.setHotelId(rating.getHotelId());
			rating1.setUserId(rating.getUserId());
			rating1.setRating(rating.getRating());
			ratingRepo.save(rating1);
		});
	}

	
	@Override
	public Rating updateRating(Rating rating, int ratingId) {
		
		Rating[] updatedRating = {null};
		ratingRepo.findById(ratingId).ifPresentOrElse(ratingObj ->{
			ratingObj.setFeedback(rating.getFeedback());
			ratingObj.setHotelId(rating.getHotelId());
			ratingObj.setRating(rating.getRating());
			updatedRating[0] = ratingRepo.save(ratingObj);
			
		}, () -> {throw new ResourceNotFoundException("Rating with given id not found "+ratingId);});
		
		return updatedRating[0];
	}
	
	@Override
	public void deleteRating(int ratingId) {
		ratingRepo.deleteById(ratingId);
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		logger.info("==================");
		 return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotlId(int hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}



}
