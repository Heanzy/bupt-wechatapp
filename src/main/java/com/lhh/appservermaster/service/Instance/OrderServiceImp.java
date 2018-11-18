package com.lhh.appservermaster.service.Instance;

import com.lhh.appservermaster.dao.OrderDao;
import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    @Override
    public List<Order> getOrdersByUserID(Integer userID) {
        return orderDao.getOrdersByUserID(userID);
    }

    @Override
    public Order getOrderByID(Integer orderID) {
        return orderDao.getOrderByID(orderID);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public boolean updateOrderInfoByID(Order order) {
        return orderDao.updateOrderInfoByID(order);
    }

    @Override
    public boolean deleteOrderByID(Integer orderID) {
        return orderDao.deleteOrderByID(orderID);
    }
}
