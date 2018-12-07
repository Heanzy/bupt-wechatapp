package com.lhh.appservermaster.service.Instance;

import com.lhh.appservermaster.dao.OrderDao;
import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.domain.query.OrderQuery;
import com.lhh.appservermaster.service.OrderService;
import com.lhh.appservermaster.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrdersByOrderType(String orderType) {
        return orderDao.getOrdersByOrderType(orderType);
    }

    @Override
    public String saveOrderPic(MultipartFile multipartFile, String path) {
        String picRename = null;
        try {
            picRename = Utils.getInstance().saveImg(multipartFile,path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return picRename;
    }

    @Override
    public List<Order> getOrdersByOrderState(String orderState) {
        return orderDao.getOrdersByOrderState(orderState);
    }

    @Override
    public List<Order> getOrdersByTakeUserID(Integer takeUserId) {
        return orderDao.getOrdersByTakeUserID(takeUserId);
    }

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

    @Override
    public List<Order> getOrdersByQuery(OrderQuery orderQuery) {
        return orderDao.getOrdersByQuery(orderQuery);
    }
}
