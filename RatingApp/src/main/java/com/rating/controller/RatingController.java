package com.rating.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	private Logger logger = LoggerFactory.getLogger("RatingController.class");

	@PostMapping("/save")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		Rating rating2 = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratings = ratingService.getAll();
		return ResponseEntity.ok(ratings);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable int ratingId) {
		Rating rating = ratingService.getRating(ratingId);
		return ResponseEntity.ok(rating);
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateRating(@RequestBody Rating rating){
		logger.info("=====================inside RatingController updateRating()======================");
		ratingService.updateRating(rating);
		return new ResponseEntity<String>("Updated successfully", HttpStatus.NO_CONTENT);
	}
	
		
	@PutMapping("/update/{ratingId}")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable int ratingId) {
		Rating updatedRating = ratingService.updateRating(rating, ratingId);
		return new ResponseEntity<Rating>(updatedRating, HttpStatus.OK);
	}

	@GetMapping("/delete/{ratingId}")
	public ResponseEntity<String> deleteRating(@PathVariable int ratingId) {
		ratingService.deleteRating(ratingId);
		return ResponseEntity.ok("delete successfully");
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable int userId) {
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratings);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable int hotelId) {
		List<Rating> ratings = ratingService.getRatingByHotlId(hotelId);
		return ResponseEntity.ok(ratings);
	}

}
