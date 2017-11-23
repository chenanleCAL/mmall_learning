package com.mmall.service;


import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by chenanle on 2017/11/23.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
}

