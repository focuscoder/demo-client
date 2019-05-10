package com.example.client.democlient.order.util;

public enum OrderStatusEnum {

    NEW_ORDER (1,"新生成"),
    WAIT_PAY (2,"待支付"),
    CANCEL(3,"已取消"),
    TIMEOUT_CANCEL(4,"超时取消"),
    PAYED(5,"已支付"),
    WAIT_CONSIGNMENT(6,"待发货"),
    CONSIGNMENTTING(7,"配送中"),
    REJECT_ORDER(8,"拒收"),
    RETURN_ORDER(9,"退回"),
    CONSIGNMENTED(10,"已签收"),
    FINISHED(11,"已完成");

    private Integer code;
    private String desc;

    private OrderStatusEnum (Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
