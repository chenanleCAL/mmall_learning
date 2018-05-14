package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenanle on 2018/5/14.
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setId(shipping.getId());
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0) {
            Map result = Maps.newHashMap();
            result.put("shippingId",shipping.getId());
            return ServerResponse.cteateBySuccess("新建地址成功",result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    public ServerResponse<String> del(Integer userId,Integer shippingId) {
        int rowCount = shippingMapper.deleteByUserIdShippingId(userId,shippingId);
        if (rowCount > 0) {
            return ServerResponse.cteateBySuccess("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    public ServerResponse update(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        shipping.setId(shipping.getId());
        int rowCount = shippingMapper.updateByShipping(shipping);
        if (rowCount > 0) {
            return ServerResponse.cteateBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    public ServerResponse<Shipping> select(Integer userId,Integer shippingId) {
        Shipping shipping = shippingMapper.selectByUserIdShippingId(userId,shippingId);
        if (shipping != null) {
            return ServerResponse.cteateBySuccess(shipping);
        }
        return ServerResponse.createByErrorMessage("无法查询到该地址");
    }

    public ServerResponse<PageInfo> list(int pageNum,int pageSize,Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.cteateBySuccess(pageInfo);
    }

}
