package com.wipe.healthy.core.service;

import com.wipe.healthy.core.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户信息服务
 * User:Created by wei.li
 * Date: on 2015/12/9.
 * Time:0:20
 */

public interface IUserService {

    /**
     * 新增用户信息
     * @param user 用户实体
     * @return 新增id
     *
     */
    Integer create(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 更新结果（true/false）
     */
    Boolean update(User user);

    /**
     * 删除用户信息
     * @param id 用户信息主键
     * @return 删除结果（true/false）
     */
    Boolean delete(Integer id);

    /**
     * 通过id查找用户信息
     * @param id 主键id
     * @return 用户信息
     */
    User findById(Integer id);

    /**
     * 根据账号查找用户信息
     * @param id 账户ID
     * @return 用户信息
     */
    User findByAccountId(Integer id);

    /**
     * 根据条件查询用户信息
     * @param query 查询条件
     * @return 用户信息列表
     */
    List<User> list(Map<String,Object> query);

    /**
     * 根据主键集合查询用户信息
     * @param ids 主键集合
     * @return 用户信息列表
     */
    List<User> batchQuery(Set<Integer> ids);
}
