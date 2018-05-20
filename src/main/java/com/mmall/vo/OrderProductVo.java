package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenanle on 2018/5/17.
 */
public class OrderProductVo {

    private List<OrderItemVo> orderItemVoList;

    private BigDecimal productTotalProce;

    private String imageHost;

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public BigDecimal getProductTotalProce() {
        return productTotalProce;
    }

    public void setProductTotalProce(BigDecimal productTotalProce) {
        this.productTotalProce = productTotalProce;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
