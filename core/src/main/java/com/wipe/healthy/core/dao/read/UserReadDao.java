package com.wipe.healthy.core.dao.read;

import com.wipe.healthy.core.model.User;

/**
 * 用户信息读操作
 * User:Created by wei.li
 * Date: on 2015/12/9.
 * Time:21:36
 */
public interface UserReadDao extends BaseReadDao<User> {
    /**
     * 根据账号查找用户信息
     * @param id 账户ID
     * @return 用户信息
     */
    User findByAccountId(Integer id);
}
