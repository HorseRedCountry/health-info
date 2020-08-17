package com.wipe.healthy.core.service;

import com.wipe.healthy.core.model.FitnessAction;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 健身行为服务
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:23:51
 */
public interface IFitnessActionService {

    /**
     * 健身行为信息新增
     * @param fitnessAction 健身行为
     * @return 新增健身信息主键
     */
    Integer create(FitnessAction fitnessAction);

    /**
     * 修改健身行为信息
     * @param fitnessAction 健身行为信息
     * @return 修改结果（true/false）
     */
    Boolean update(FitnessAction fitnessAction);

    /**
     * 删除健身信息行为
     * @param id 健身行为信息主键
     * @return 删除结果（true/false）
     */
    Boolean delete(Integer id);

    /**
     * 根据主键查找健身行为信息
     * @param id 主键
     * @return 健身行为信息
     */
    FitnessAction findById(Integer id);

    /**
     * 根据条件查询健身行为信息
     * @param query 查询条件
     * @return 健身行为信息列表
     */
    List<FitnessAction> list(Map<String,Object> query);

    /**
     * 根据健身类型查询健身行为信息
     * @param style 类型
     * @return 健身行为信息列表
     */
    List<FitnessAction> list(Integer style);
    /**
     * 根据主键集合查询健身行为信息
     * @param ids 主键集合
     * @return 健身行为信息列表
     */
    List<FitnessAction> batchQuery(Set<Integer> ids);
}
