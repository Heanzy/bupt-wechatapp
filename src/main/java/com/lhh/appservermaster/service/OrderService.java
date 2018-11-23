package com.lhh.appservermaster.service;

import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.domain.query.OrderQuery;

import java.util.List;

public interface OrderService {

    /**
     *
     * @return 所有订单信息
     */
    List<Order> getAllOrders();

    /**
     *
     * @param userID
     * @return 返回用户订单信息
     */
    List<Order> getOrdersByUserID(Integer userID);

    /**
     *
     * @param orderID
     * @return 根据订单id返回订单信息
     */
    Order getOrderByID(Integer orderID);

    /**
     *
     * @param order
     * @return true 添加订单成功
     */
    boolean addOrder(Order order);

    /**
     *
     * @param Order
     * @return true 成功更新订单
     */
    boolean updateOrderInfoByID(Order Order);

    /**
     *
     * @param orderID
     * @return true 成功删除订单
     */
    boolean deleteOrderByID(Integer orderID);

    /**
     * 根据字段orderName userId expressAdressName orderPay addTime模糊查询
     * @param orderQuery
     * @return 查询结果
     */
    List<Order> getOrdersByQuery(OrderQuery orderQuery);
}
