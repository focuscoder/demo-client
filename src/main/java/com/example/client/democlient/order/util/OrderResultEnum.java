package com.example.client.democlient.order.util;

public enum OrderResultEnum {

    EXCEPTION(-1,"系统异常"),
    PARAM(0,"参数错误"),
    ERROR(1,"下单失败"),
    SUCCESS(2,"下单成功"),
    NOSTOCK(3,"库存不足");

    private Integer code;
    private String desc;

    private OrderResultEnum(Integer code, String desc) {
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
