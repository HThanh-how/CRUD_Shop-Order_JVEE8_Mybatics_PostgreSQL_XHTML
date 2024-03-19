package org.example.crud_shoporder_jvee8_mybatics_postgresql.bean;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.RestaurantMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.util.MyBatisUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "restaurantBean")
@SessionScoped
public class RestaurantBean {
    @Setter
    @Inject
    private RestaurantMapper restaurantMapper;

    @Getter
    private List<Restaurant> restaurants;

    @Getter
    @Setter
    private Restaurant restaurant = new Restaurant();
    public RestaurantBean() {
        restaurantMapper = new RestaurantMapper(MyBatisUtil.getSqlSessionFactory().openSession());
        this.restaurants = restaurantMapper.getAllRestaurants();
        System.out.println("Loaded restaurants: " + this.restaurants);
    }

    @PostConstruct
    public void init() {
        restaurantMapper = new RestaurantMapper(MyBatisUtil.getSqlSessionFactory().openSession());
        this.restaurants = restaurantMapper.getAllRestaurants();
        System.out.println("Loaded restaurants: " + this.restaurants);
    }
    // Add this method
    // Add this method
//    @Getter
//    @Setter
//    private Restaurant restaurant;

    public void addRestaurant() {
        restaurantMapper.insertRestaurant(restaurant);
        this.restaurants = restaurantMapper.getAllRestaurants();
        this.restaurant = new Restaurant(); // Reset the restaurant field after adding
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