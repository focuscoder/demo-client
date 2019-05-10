package com.example.client.democlient;

import com.example.client.democlient.order.service.OrderService;
import com.example.client.democlient.order.util.OrderResultEnum;
import com.example.client.democlient.order.util.ReqResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/test")
public class TestSpringCloud {


    Logger logger = LoggerFactory.getLogger(TestSpringCloud.class);

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/queryName")
    public String queryName() {
        return "我是spring-cloud";
    }

    /**
     * 用户下单服务逻辑
     * @param courseId 课程Id
     * @param userId 用户Id
     * @param count 购买数量
     * @param price 订单金额
     * @return
     */
    @RequestMapping(value = "/placeOrder")
    public ReqResult placeOrder(Integer courseId, Integer userId, Integer count, BigDecimal price) {
        logger.info("===》用户下单服务开始课程ID{},用户Id{}，数量{},单价{}",courseId,userId,count,price);
        ReqResult reqResult = new ReqResult();
        try {
            return orderService.placeOrder(courseId, userId, count, price,reqResult);
        } catch (Exception e) {
            logger.error("下单服务发生错误,用户Id==>>{},课程Id==>{},错误信息==> {} ",userId,courseId,e.getMessage());
            reqResult.setCode(OrderResultEnum.EXCEPTION.getCode());
            reqResult.setMsg(OrderResultEnum.EXCEPTION.getDesc());
            return reqResult;
        }
    }
}
