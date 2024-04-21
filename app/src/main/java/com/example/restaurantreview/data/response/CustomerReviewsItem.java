package com.example.restaurantreview.data.response;

import com.google.gson.annotations.SerializedName;

public class CustomerReviewsItem {

	@SerializedName("date")
	private final String date;

	@SerializedName("name")
	private final String name;

	@SerializedName("review")
	private final String review;

	public CustomerReviewsItem(String date, String name, String review) {
		this.date = date;
		this.name = name;
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getReview() {
		return review;
	}
}
