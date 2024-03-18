package org.example.crud_shoporder_jvee8_mybatics_postgresql;

import jakarta.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.RestaurantMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.util.MyBatisUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantTest {
    //    @InjectMocks
    @Inject
    private RestaurantBean restaurantBean;

    //    @Mock
    @Inject
    private RestaurantMapper restaurantMapper;

    @BeforeEach
    public void setup() {
        restaurantMapper = new RestaurantMapper(MyBatisUtil.getSqlSessionFactory().openSession());
        restaurantBean = new RestaurantBean();
        restaurantBean.setRestaurantMapper(restaurantMapper);
    }
    @Test
    public void testGetRestaurants() {
        Restaurant restaurant1 = new Restaurant();
        Restaurant restaurant2 = new Restaurant();
        List<Restaurant> expectedRestaurants = Arrays.asList(restaurant1, restaurant2);

        when(restaurantMapper.getAllRestaurants()).thenReturn(expectedRestaurants);

        restaurantBean.init();
        List<Restaurant> actualRestaurants = restaurantBean.getRestaurants();

        assertEquals(expectedRestaurants, actualRestaurants);
        verify(restaurantMapper, times(1)).getAllRestaurants();
    }

    @Test
    public void testAddRestaurant() {
        Restaurant restaurant = new Restaurant();

        restaurantBean.addRestaurant(restaurant);

        verify(restaurantMapper, times(1)).insertRestaurant(restaurant);
        verify(restaurantMapper, times(1)).getAllRestaurants();
    }

    @Test
    public void testUpdateRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(2);
        restaurant.setName("New Name");
        restaurant.setAddress("New Address");
        restaurantBean.updateRestaurant(restaurant);

    }

    @Test
    public void testDeleteRestaurant() {
        int id = 1;

        restaurantBean.deleteRestaurant(id);

        verify(restaurantMapper, times(1)).deleteRestaurant(id);
        verify(restaurantMapper, times(1)).getAllRestaurants();
    }

    @Test
    public void testInsertRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant 2");
        restaurant.setAddress("Test Address");

        // Call the method under test
        restaurantBean.addRestaurant(restaurant);

        // Verify that the mapper's insertRestaurant() method was called with the correct argument
//        verify(restaurantMapper, times(1)).insertRestaurant(restaurant);
    }
}