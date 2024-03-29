package org.example.crud_shoporder_jvee8_mybatics_postgresql;

import jakarta.inject.Inject;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.bean.MenuBean;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.bean.RestaurantBean;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.MenuMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.RestaurantMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Menu;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.util.MyBatisUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantTest {
    //    @InjectMocks
    @Inject
    private RestaurantBean restaurantBean;

    @Inject
    private MenuBean menuBean;

    //    @Mock
    @Inject
    private RestaurantMapper restaurantMapper;

    @Inject
    private MenuMapper menuMapper;

    @BeforeEach
    public void setup() {
        restaurantMapper = new RestaurantMapper(MyBatisUtil.getSqlSessionFactory().openSession());
        restaurantBean = new RestaurantBean();
        restaurantBean.setRestaurantMapper(restaurantMapper);
        menuMapper = new MenuMapper(MyBatisUtil.getSqlSessionFactory().openSession());
        menuBean = new MenuBean();
        menuBean.setMenuMapper(menuMapper);
    }
    @Test
    public void testGetRestaurants() {
        List<Restaurant> restaurants = restaurantMapper.getAllRestaurants();
        printRestaurant(restaurants);
    }
    @Test
    public void testAddRestaurant() {
        Restaurant restaurant = new Restaurant();

//        restaurantBean.addRestaurant(restaurant);

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
        int id = 4;

//        restaurantBean.deleteRestaurant(id);

//        verify(restaurantMapper, times(1)).deleteRestaurant(id);
//        verify(restaurantMapper, times(1)).getAllRestaurants();
    }

    @Test
    public void testDeleteMenu() {
        int id = 1;

        menuBean.deleteMenu(id);
    }
    @Test
    public void testInsertRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant 2");
        restaurant.setAddress("Test Address");

        // Call the method under test
//        restaurantBean.addRestaurant(restaurant);

        // Verify that the mapper's insertRestaurant() method was called with the correct argument
//        verify(restaurantMapper, times(1)).insertRestaurant(restaurant);
    }
    @Test
    public void tesInsertMenu() {
        Menu menu = new Menu();
        menu.setName("Test Menu 2");
        menu.setPrice(100);

        // Call the method under test
        menuBean.addMenu(menu);



    }

    private void printRestaurant(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            System.out.println("ID: " + restaurant.getId());
            System.out.println("Address: " + restaurant.getAddress());
            System.out.println("Name: " + restaurant.getName());
        }
    }
}