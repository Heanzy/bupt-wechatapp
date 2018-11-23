package com.lhh.appservermaster.web;

import com.lhh.appservermaster.domain.Order;
import com.lhh.appservermaster.domain.query.OrderQuery;
import com.lhh.appservermaster.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/all")
    public @ResponseBody
    List<Order> getAllorders(){
        return  orderService.getAllOrders();
    }

    @PostMapping("/order/add")
    public @ResponseBody boolean addOrder(Order order){
        return orderService.addOrder(order);
    }

    @GetMapping("/order/user")
    public @ResponseBody List<Order> getOrdersByUserID(@RequestParam Integer userId){
        return orderService.getOrdersByUserID(userId);
    }

    @GetMapping("/order")
    public @ResponseBody Order getOrderByID(@RequestParam Integer orderId){
        return orderService.getOrderByID(orderId);
    }

    @PostMapping("/order/update")
    public @ResponseBody boolean updateOrderByID(Order order){
        return orderService.updateOrderInfoByID(order);
    }

    @PostMapping("/order/delete")
    public @ResponseBody boolean deleteOrderByID(@RequestParam Integer orderId){
        return orderService.deleteOrderByID(orderId);
    }

    @GetMapping("/order/query")
    public @ResponseBody List<Order> getOrdersByQuery(OrderQuery orderQuery){
        return orderService.getOrdersByQuery(orderQuery);
    }
}
