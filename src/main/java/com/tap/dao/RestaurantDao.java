package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;


public interface RestaurantDao {
	void addRestaurant(Restaurant restaurant);

	Restaurant getRestaurant(int restaurantId);

	List<Restaurant> getAll();

	void updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(int restaurantId);

}
