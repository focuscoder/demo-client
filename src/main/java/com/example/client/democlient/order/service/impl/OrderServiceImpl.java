package com.example.client.democlient.order.service.impl;

import com.example.client.democlient.order.OrderEntity.CourseVo;
import com.example.client.democlient.order.OrderEntity.OrderVo;
import com.example.client.democlient.order.OrderEntity.StockVo;
import com.example.client.democlient.order.dao.CourseDaoTemplate;
import com.example.client.democlient.order.dao.OrderDaoTemplate;
import com.example.client.democlient.order.dao.StockDaoTemplate;
import com.example.client.democlient.order.service.OrderService;
import com.example.client.democlient.order.util.OrderException;
import com.example.client.democlient.order.util.OrderResultEnum;
import com.example.client.democlient.order.util.OrderStatusEnum;
import com.example.client.democlient.order.util.ReqResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDaoTemplate orderDaoTemplate;
    @Resource
    private CourseDaoTemplate courseDaoTemplate;
    @Resource
    private StockDaoTemplate stockDaoTemplate;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ReqResult placeOrder (Integer courseId, Integer userId, Integer count, BigDecimal price, ReqResult reqResult) throws OrderException {
        //校验参数
        if (!checkParam(courseId,count,price)) {
            reqResult.setCode(OrderResultEnum.PARAM.getCode());
            reqResult.setMsg(OrderResultEnum.PARAM.getDesc());
            return reqResult;
        }
        //预占库存
        boolean stockResult = reduceStock(courseId, count);
        if (stockResult) {
            //生成订单
            int orderFlag = createOrder(courseId, userId, count, price);
            if (orderFlag > 0) {
                // todo 待支付
                // 。。。
                reqResult.setCode(OrderResultEnum.SUCCESS.getCode());
                reqResult.setMsg(OrderResultEnum.SUCCESS.getDesc());
                return reqResult;
            }
            throw new OrderException(OrderResultEnum.EXCEPTION.getDesc());
        }
        //库存不足
        reqResult.setCode(OrderResultEnum.NOSTOCK.getCode());
        reqResult.setMsg(OrderResultEnum.NOSTOCK.getDesc());
        return reqResult;
    }

    private boolean reduceStock(Integer courseId, Integer count) {
        StockVo stockVo = stockDaoTemplate.queryStockByCouseId(courseId);
        if (stockVo == null) {
            return false;
        }
        if (stockVo.getStockNum() == 0 || stockVo.getStockNum() < count) {
            return false;
        }
        Long newVersion = System.currentTimeMillis();
        int result = stockDaoTemplate.updateStock(courseId,count, stockVo.getVersionFlag(),newVersion);
        if (result > 0) {
            return true;
        }
        return false;
        //StockVo stockVo = select id,stock_num from stock_table where courseId = courseId
        //int result = update stock_table set stock_num = stock_num - count, version_flag = newVersion where courseId = courseId and version_flag = versionFlag
    }

    private int createOrder(Integer courseId, Integer userId, Integer count, BigDecimal price) {
        OrderVo orderVo = new OrderVo();
        int uuid = UUID.randomUUID().toString().hashCode();
        if (userId < 0) {
            userId = uuid * (-1);
        }
        orderVo.setId(1L);
        orderVo.setOrderId(Integer.toUnsignedLong(userId));//todo 订单号生成策略待定
        orderVo.setCourseId(courseId);
        orderVo.setUserId(userId);
        orderVo.setNum(count);
        orderVo.setOrderPrice(price);
        orderVo.setOrderStatus(OrderStatusEnum.NEW_ORDER.getCode());
        return  orderDaoTemplate.createOrder(orderVo);
    }

    /**
     * 粗粒度校验,可精确到具体哪个参数有误
     * userId参数在前置拦截器中校验
     * @param courseId
     * @param count
     * @param price
     * @return
     */
    private boolean checkParam(Integer courseId, Integer count, BigDecimal price) {
        boolean flag = true;
        if (!checkCourseId(courseId)) {
            flag = false;
        }
        if (!checkCount(count)) {
            flag = false;
        }
        if (!checkPrice(price)) {
            flag = false;
        }
        return flag;
    }

    private boolean checkCourseId (Integer courseId) {
        if (courseId == null) {
            return false;
        }
        //todo 当前用户是否有权限购买所有商品？
        CourseVo course = courseDaoTemplate.getCourseById(courseId);
        if (course != null) {
            return true;
        }
        return false;
    }

    private boolean checkCount (Integer count) {
        if (count == null) {
            return false;
        }
        if (count > 0) {
            return true;
        }
        return false;
    }

    private boolean checkPrice (BigDecimal count) {
        if (count == null) {
            return false;
        }
        int result = count.compareTo(BigDecimal.ZERO);
        if (result == 1) { // 大于0
            return true;
        }
        return false;
    }

}
