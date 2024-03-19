package org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Order;

import javax.faces.bean.ApplicationScoped;
import java.util.List;

@Named
@ApplicationScoped
public class OrderMapper {
    private SqlSession sqlSession;

    @Inject
    public OrderMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // This method is for testing purposes only
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Order> getAllOrders() {
        return sqlSession.selectList("getAllOrders");
    }

    public void insertOrder(Order order) {
        sqlSession.insert("insertOrder", order);
        sqlSession.commit();
    }

    public void updateOrder(Order order) {
        sqlSession.update("updateOrder", order);
        sqlSession.commit();
    }

    public void deleteOrder(int id) {
        sqlSession.delete("deleteOrder", id);
        sqlSession.commit();
    }
}