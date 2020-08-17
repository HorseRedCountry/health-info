package com.wipe.healthy.core.service.impl;

import com.wipe.healthy.core.dao.read.ActionInfoReadDao;
import com.wipe.healthy.core.dao.write.ActionInfoWriteDao;
import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.service.IActionInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 健身信息服务
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:23:42
 */
@Service
public class ActionInfoService implements IActionInfoService{
    @Resource
    ActionInfoReadDao actionInfoReadDao;

    @Resource
    ActionInfoWriteDao actionInfoWriteDao;
    /**
     * 健身信息详情新增
     *
     * @param actionInfo 健身信息详情
     * @return 新增的健身信息详情主键
     */
    @Override
    public Integer create(ActionInfo actionInfo) {
        return this.actionInfoWriteDao.create(actionInfo);
    }

    /**
     * 健身信息详情修改
     *
     * @param actionInfo 健身信息详情
     * @return 修改结果（true/false）
     */
    @Override
    public Boolean update(ActionInfo actionInfo) {
        return this.actionInfoWriteDao.update(actionInfo);
    }

    /**
     * 健身信息详情详情删除
     *
     * @param id 健身信息详情
     * @return 删除结果（true/false）
     */
    @Override
    public Boolean delete(Integer id) {
        return this.actionInfoWriteDao.delete(id);
    }

    /**
     * 根据主键查找健身信息详情
     *
     * @param id 主键信息
     * @return 健身信息
     */
    @Override
    public ActionInfo findById(Integer id) {
        return this.actionInfoReadDao.findById(id);
    }

    /**
     * 根据条件查询健身信息详情
     *
     * @param query 查询条件
     * @return 健身信息详情列表
     */
    @Override
    public List<ActionInfo> list(Map<String, Object> query) {
        return this.actionInfoReadDao.list(query);
    }

    /**
     * 根据id集合查询健身信息详情
     *
     * @param ids 主键集合
     * @return 健身信息详情列表
     */
    @Override
    public List<ActionInfo> batchQuery(Set<Integer> ids) {
        return this.actionInfoReadDao.batchQuery(ids);
    }
}
