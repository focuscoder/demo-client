package com.example.client.democlient.order.dao;

import com.example.client.democlient.order.OrderEntity.StockVo;

public interface StockDaoTemplate {

    StockVo queryStockByCouseId(Integer courseId);

    int updateStock(Integer courseId, Integer stockNum, Long versionFlag, Long versionFlagNew);
}
