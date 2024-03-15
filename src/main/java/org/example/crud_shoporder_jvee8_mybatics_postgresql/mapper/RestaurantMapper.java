package org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper;

import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;

import java.util.List;

// RestaurantMapper.java
public interface RestaurantMapper {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurant(int id);
    void insertRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id);
}