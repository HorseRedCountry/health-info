package com.wipe.healthy.core.service;

import com.wipe.healthy.core.model.Account;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 账户信息服务.
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:23:06
 */
public interface IAccountService {

    /**
     * 账户信息新增
     * @param account 账户信息
     * @return 新增账户主键
     */
    Integer create(Account account);

    /**
     * 账户信息修改
     * @param account 账户信息
     * @return 修改结果（true/false）
     */
    Boolean update(Account account);

    /**
     * 账户信息删除
     * @param id 账户信息主键
     * @return 删除结果（true/false）
     */
    Boolean delete(Integer id);


    /**
     * 根据主键查找账户信息
     * @param id 账户主键
     * @return 账户信息
     */
    Account findById(Integer id);

    /**
     * 根据登陆名查找账户
     * @param englishName 登陆名
     * @return 账号信息
     */
    Account findByName(String englishName);

    /**
     * 根据条件查询账户信息
     * @param query 查询条件
     * @return 账户信息列表
     */
    List<Account> list(Map<String,Object> query);

    /**
     * 根据id集合查找账户信息
     * @param ids 主键集合
     * @return 账户信息列表
     */
    List<Account> batchQuery(Set<Integer> ids);
}
