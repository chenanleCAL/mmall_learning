package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

/**
 * Created by chenanle on 2017/12/7.
 */
public interface IProductService {

    /**
     * 商品新增，保存，更新等功能
     *
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduc(Product product);


    /**
     * 更新商品上下架状态的功能
     *
     * @param productId
     * @param status
     * @return
     */
    ServerResponse<String> updateSaleStatus(Integer productId, Integer status);
}
