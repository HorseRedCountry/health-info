package com.wipe.healthy.core.service.impl;

import com.wipe.healthy.core.dao.read.AccountReadDao;
import com.wipe.healthy.core.dao.write.AccountWriteDao;
import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.core.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 账户信息服务
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:23:21
 */
@Service
public class AccountService implements IAccountService{

    @Resource
    AccountReadDao accountReadDao;

    @Resource
    AccountWriteDao accountWriteDao;
    /**
     * 账户信息新增
     *
     * @param account 账户信息
     * @return 新增账户主键
     */
    @Override
    public Integer create(Account account) {
        return this.accountWriteDao.create(account);
    }

    /**
     * 账户信息修改
     *
     * @param account 账户信息
     * @return 修改结果（true/false）
     */
    @Override
    public Boolean update(Account account) {
        return this.accountWriteDao.update(account);
    }

    /**
     * 账户信息删除
     *
     * @param id 账户信息主键
     * @return 删除结果（true/false）
     */
    @Override
    public Boolean delete(Integer id) {
        return this.accountWriteDao.delete(id);
    }

    /**
     * 根据主键查找账户信息
     *
     * @param id 账户主键
     * @return 账户信息
     */
    @Override
    public Account findById(Integer id) {
        return this.accountReadDao.findById(id);
    }


    /**
     * 根据登陆名查找账户
     *
     * @param englishName 登陆名
     * @return 账号信息
     */
    @Override
    public Account findByName(String englishName) {
        return this.accountReadDao.findByName(englishName);
    }

    /**
     * 根据条件查询账户信息
     *
     * @param query 查询条件
     * @return 账户信息列表
     */
    @Override
    public List<Account> list(Map<String, Object> query) {
        return this.accountReadDao.list(query);
    }

    /**
     * 根据id集合查找账户信息
     *
     * @param ids 主键集合
     * @return 账户信息列表
     */
    @Override
    public  List<Account> batchQuery(Set<Integer> ids) {
        return this.accountReadDao.batchQuery(ids);
    }
}
