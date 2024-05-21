package com.rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingId;
	private String feedback;
	private int userId;
	private int hotelId;
	private int rating;
	
	@Transient
	private Hotel hotel;
}
