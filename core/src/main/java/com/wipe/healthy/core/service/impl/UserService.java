package com.wipe.healthy.core.service.impl;

import com.wipe.healthy.core.dao.read.UserReadDao;
import com.wipe.healthy.core.dao.write.UserWriteDao;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户信息服务实现
 * User:Created by wei.li
 * Date: on 2015/12/9.
 * Time:0:25
 */
@Service("userService")
public class UserService implements IUserService{

    @Resource
    UserWriteDao userWriteDao;

    @Resource
    UserReadDao userReadDao;

    /**
     * 新增用户信息
     * @param user 用户实体
     * @return 新增id
     *
     */
    @Override
    public Integer create(User user) {
        return this.userWriteDao.create(user);
    }

    /**
     * 通过id查找用户信息
     *
     * @param id 主键id
     * @return 用户信息
     */
    @Override
    public User findById(Integer id) {
        return this.userReadDao.findById(id);
    }

    /**
     * 根据账号查找用户信息
     *
     * @param id 账户ID
     * @return 用户信息
     */
    @Override
    public User findByAccountId(Integer id) {
        return this.userReadDao.findByAccountId(id);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 更新结果（true/false）
     */
    @Override
    public Boolean update(User user) {
        return this.userWriteDao.update(user);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户信息主键
     * @return 删除结果（true/false）
     */
    @Override
    public Boolean delete(Integer id) {
        return this.userWriteDao.delete(id);
    }

    /**
     * 根据条件查询用户信息
     *
     * @param query 查询条件
     * @return 用户信息列表
     */
    @Override
    public List<User> list(Map<String, Object> query) {
        return this.userReadDao.list(query);
    }

    /**
     * 根据主键集合查询用户信息
     *
     * @param ids 主键集合
     * @return 用户信息列表
     */
    @Override
    public List<User> batchQuery(Set<Integer> ids) {
        return this.userReadDao.batchQuery(ids);
    }
}
