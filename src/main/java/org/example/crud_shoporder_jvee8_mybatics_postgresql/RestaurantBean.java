package org.example.crud_shoporder_jvee8_mybatics_postgresql;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.RestaurantMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "restaurantBean")
@SessionScoped
public class RestaurantBean {
    @Inject
    private RestaurantMapper restaurantMapper;

    private List<Restaurant> restaurants;

    @PostConstruct
    public void init() {
        this.restaurants = restaurantMapper.getAllRestaurants();
    }

    public List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public void setRestaurantMapper(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantMapper.insertRestaurant(restaurant);
//        this.restaurants = restaurantMapper.getAllRestaurants();
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurantMapper.updateRestaurant(restaurant);
        this.restaurants = restaurantMapper.getAllRestaurants();
    }

    public void deleteRestaurant(int id) {
        restaurantMapper.deleteRestaurant(id);
        this.restaurants = restaurantMapper.getAllRestaurants();
    }
}