package org.example.crud_shoporder_jvee8_mybatics_postgresql.bean;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.OrderMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean {
    @Inject
    private OrderMapper orderMapper;

    private List<Order> orders;

    @PostConstruct
    public void init() {
        this.orders = orderMapper.getAllOrders();
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void addOrder(Order order) {
        orderMapper.insertOrder(order);
        this.orders = orderMapper.getAllOrders();
    }

    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
        this.orders = orderMapper.getAllOrders();
    }

    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);
        this.orders = orderMapper.getAllOrders();
    }
}