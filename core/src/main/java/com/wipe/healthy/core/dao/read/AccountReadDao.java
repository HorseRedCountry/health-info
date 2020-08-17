package com.wipe.healthy.core.dao.read;

import com.wipe.healthy.core.model.Account;

/**
 * 账号信息读操作
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:11:47
 */
public interface AccountReadDao extends BaseReadDao<Account>{

    /**
     * 根据登陆名查找账户
     * @param englishName 登陆名
     * @return 账号信息
     */
    public Account findByName(String englishName);
}
