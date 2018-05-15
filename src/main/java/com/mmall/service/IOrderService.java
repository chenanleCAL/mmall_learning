package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * Created by chenanle on 2018/5/15.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);
}
