package com.example.client.democlient.order.util;

public class OrderException extends Exception {

    private String errCode;

    private String errorMsg;

    public OrderException(String errorMsg) {
        super(errorMsg);
    }

    public OrderException(String errCode, String errorMsg) {
        super(errorMsg);
        this.errCode = errCode;
        this.errorMsg = errorMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
