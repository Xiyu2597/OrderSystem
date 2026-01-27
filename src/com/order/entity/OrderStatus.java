package com.order.entity;

public enum OrderStatus {
    CREATED("已创建"),PROCESSING("处理中"),PROCESSED("已完成");
    private String desc;
    OrderStatus(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
}
