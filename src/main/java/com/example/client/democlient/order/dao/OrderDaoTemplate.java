package com.example.client.democlient.order.dao;


import com.example.client.democlient.order.OrderEntity.OrderVo;

public interface OrderDaoTemplate {

    int createOrder(OrderVo orderVo);

}
