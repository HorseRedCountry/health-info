package com.wipe.healthy.web.utils;

import com.wipe.healthy.core.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Session 管理工具类
 * User:Created by wei.li
 * Date: on 2016/3/11.
 * Time:14:54
 */
public class SessionUtils {

    /**
     * 获取登陆账户
     * @param request 请求参数
     * @return 登陆账户
     */
    public static Account getAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        Account sessionAccount = (Account)session.getAttribute("account");
        return sessionAccount;
    }
}
