package com.lhh.appservermaster.service;

import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.domain.query.OrderQuery;
import org.springframework.web.multipart.MultipartFile;

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
     * 模糊查询订单
     * @param orderQuery
     * @return 查询结果
     */
    List<Order> getOrdersByQuery(OrderQuery orderQuery);

    /**
     * 根据代领人id查询订单
     * @param takeUserId
     * @return
     */
    List<Order> getOrdersByTakeUserID(Integer takeUserId);

    /**
     * 根据订单状态查询
     * @param orderState
     * @return
     */
    List<Order> getOrdersByOrderState(String orderState);

    /**
     * 保存订单图片
     * @param multipartFile
     * @param path 存储路径
     * @return 图片UUID
     */
    String saveOrderPic(MultipartFile multipartFile, String path);

    /**
     * 根据订单类型查询订单
     * @param orderType
     * @return
     */
    List<Order> getOrdersByOrderType(String orderType);
}
