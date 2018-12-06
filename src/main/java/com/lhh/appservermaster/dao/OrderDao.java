package com.lhh.appservermaster.dao;

import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.domain.query.OrderQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {
    /**
     *
     * @return 所有订单数据
     */
    List<Order> getAll();

    /**
     *
     * @param ID 订单id
     * @return 根据订单id返回订单信息
     */
    Order getOrderByID(@Param("orderId") Integer ID);

    /**
     *
     * @param userId
     * @return 返回用户的订单信息
     */
    List<Order> getOrdersByUserID(@Param("userId") Integer userId);

    /**
     *
     * @param order
     * @return true 添加订单成功
     */
    boolean addOrder(@Param("order") Order order);

    /**
     *
     * @param order
     *
     * @return true 成功更新订单信息
     */
    boolean updateOrderInfoByID(@Param("order") Order order);

    /**
     *
     * @param orderId
     * @return true 成功删除订单信息
     */
    boolean deleteOrderByID(@Param("orderId") Integer orderId);

    /**
     * 模糊查询
     * @param orderQuery
     * @return 查询结果
     */
    List<Order> getOrdersByQuery(@Param("orderQuery") OrderQuery orderQuery);

    /**
     *
     * @param takeUserId
     * @return 根据代领人id查询订单
     */
    List<Order> getOrdersByTakeUserID(@Param("takeUserId") Integer takeUserId);

    /**
     * 根据订单状态查询
     * @param orderState
     * @return
     */
    List<Order> getOrdersByOrderState(@Param("orderState") String orderState);
}
