package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

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


    /**
     * 后台获取商品详情功能开发及PropertiesUtil配置工具，DateTimeUtil时间处理工具开发
     *
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
}
