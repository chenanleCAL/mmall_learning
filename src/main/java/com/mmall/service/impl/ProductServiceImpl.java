package com.mmall.service.impl;

import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenanle on 2017/12/7.
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;


    /**
     * 商品新增，保存，更新等功能
     *
     * @param product
     * @return
     */
    public ServerResponse saveOrUpdateProduc(Product product) {
        if (product != null) {
            if (StringUtils.isNotBlank(product.getSubImages())) {
                String[] subImagesArray = product.getSubImages().split(",");
                if (subImagesArray.length > 0) {
                    product.setMainImage(subImagesArray[0]);
                }
            }
            if (product.getId() != null) {
                int rowCount = productMapper.updateByPrimaryKey(product);
                if (rowCount > 0) {
                    return ServerResponse.cteateBySuccess("更新产品成功");
                }
                return ServerResponse.createByErrorMessage("更新产品失败");
            } else {
                int rowCount = productMapper.insert(product);
                if (rowCount > 0) {
                    return ServerResponse.cteateBySuccess("新增产品成功");
                }
                return ServerResponse.createByErrorMessage("新增产品失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新的产品参数不正确");
    }


    /**
     * 更新商品上下架状态的功能
     *
     * @param productId
     * @param status
     * @return
     */
    public ServerResponse<String> updateSaleStatus(Integer productId, Integer status) {
        if (productId == null || status == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount > 0) {
            return ServerResponse.cteateBySuccess("修改产品销售状态成功");
        }
        return ServerResponse.createByErrorMessage("修改产品销售状态失败");
    }

}
