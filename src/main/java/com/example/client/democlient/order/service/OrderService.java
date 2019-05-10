package com.example.client.democlient.order.service;


import com.example.client.democlient.order.util.OrderException;
import com.example.client.democlient.order.util.ReqResult;

import java.math.BigDecimal;

public interface OrderService {


    ReqResult placeOrder (Integer courseId, Integer userId, Integer count, BigDecimal price, ReqResult reqResult) throws OrderException;

}
