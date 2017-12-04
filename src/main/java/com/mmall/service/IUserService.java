package com.mmall.service;


import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by chenanle on 2017/11/23.
 */
public interface IUserService {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 检查用户是否有效
     *
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 忘记密码
     *
     * @param username
     * @return
     */
    ServerResponse selectQuestion(String username);

    /**
     * 提交问题答案
     *
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 忘记密码的重置密码
     *
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登录状态下重置密码
     *
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    ServerResponse<String> ResetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新用户个人信息
     *
     * @param user
     * @return
     */
    ServerResponse<User> updateInformation(User user);
}

