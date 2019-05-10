package com.example.client.democlient.order.OrderEntity;

import java.math.BigDecimal;
import java.util.Date;

public class StockVo {

    private Long id;
    private Integer courseId;
    private String courseName;
    private BigDecimal price;
    private Long stockNum;
    private Date updateTime;
    private Long versionFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getStockNum() {
        return stockNum;
    }

    public void setStockNum(Long stockNum) {
        this.stockNum = stockNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(Long versionFlag) {
        this.versionFlag = versionFlag;
    }
}
