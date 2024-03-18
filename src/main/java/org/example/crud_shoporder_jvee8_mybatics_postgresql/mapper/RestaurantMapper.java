package org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Restaurant;

import javax.faces.bean.ApplicationScoped;
import java.util.List;

@Named
@ApplicationScoped
public class RestaurantMapper {
    private SqlSession sqlSession;

    @Inject
    public RestaurantMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // This method is for testing purposes only
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Restaurant> getAllRestaurants() {
        return sqlSession.selectList("getAllRestaurants");
    }

    public void insertRestaurant(Restaurant restaurant) {
        sqlSession.insert("insertRestaurant", restaurant);
        sqlSession.commit();
    }

    public void updateRestaurant(Restaurant restaurant) {
        sqlSession.update("updateRestaurant", restaurant);
        sqlSession.commit();
    }

    public void deleteRestaurant(int id) {
        sqlSession.delete("deleteRestaurant", id);
        sqlSession.commit();
    }
}