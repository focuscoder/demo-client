package com.example.client.democlient.order.util;

/**
 * 相应结果对象
 * @param <T>
 */
public class ReqResult<T>  {

    private Integer code;
    private String msg;
    private T data;

    public ReqResult () {}

    public ReqResult (Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
