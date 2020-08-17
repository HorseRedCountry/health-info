package com.wipe.healthy.core.service.impl;

import com.google.common.collect.Maps;
import com.wipe.healthy.core.dao.read.FitnessActionReadDao;
import com.wipe.healthy.core.dao.write.FitnessActionWriteDao;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healthy.core.service.IFitnessActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 健身行为信息服务
 * User:Created by wei.li
 * Date: on 2015/12/11.
 * Time:0:03
 */
@Service
public class FitnessActionService implements IFitnessActionService{
    @Resource
    FitnessActionReadDao fitnessActionReadDao;

    @Resource
    FitnessActionWriteDao fitnessActionWriteDao;

    /**
     * 健身行为信息新增
     *
     * @param fitnessAction 健身行为
     * @return 新增健身信息主键
     */
    @Override
    public Integer create(FitnessAction fitnessAction) {
        return this.fitnessActionWriteDao.create(fitnessAction);
    }

    /**
     * 修改健身行为信息
     *
     * @param fitnessAction 健身行为信息
     * @return 修改结果（true/false）
     */
    @Override
    public Boolean update(FitnessAction fitnessAction) {
        return this.fitnessActionWriteDao.update(fitnessAction);
    }

    /**
     * 删除健身信息行为
     *
     * @param id 健身行为信息主键
     * @return 删除结果（true/false）
     */
    @Override
    public Boolean delete(Integer id) {
        return this.fitnessActionWriteDao.delete(id);
    }

    /**
     * 根据主键查找健身行为信息
     *
     * @param id 主键
     * @return 健身行为信息
     */
    @Override
    public FitnessAction findById(Integer id) {
        return this.fitnessActionReadDao.findById(id);
    }

    /**
     * 根据条件查询健身行为信息
     *
     * @param query 查询条件
     * @return 健身行为信息列表
     */
    @Override
    public List<FitnessAction> list(Map<String, Object> query) {
        return this.fitnessActionReadDao.list(query);
    }

    /**
     * 根据健身类型查询健身行为信息
     *
     * @param style 类型
     * @return 健身行为信息列表
     */
    @Override
    public List<FitnessAction> list(Integer style) {
        Map<String,Object> query = Maps.newHashMap();
        query.put("style",style);
        return this.fitnessActionReadDao.list(query);
    }

    /**
     * 根据主键集合查询健身行为信息
     *
     * @param ids 主键集合
     * @return 健身行为信息列表
     */
    @Override
    public List<FitnessAction> batchQuery(Set<Integer> ids) {
        return this.fitnessActionReadDao.batchQuery(ids);
    }
}
