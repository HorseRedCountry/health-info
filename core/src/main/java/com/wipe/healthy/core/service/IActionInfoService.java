package com.wipe.healthy.core.service;

import com.wipe.healthy.core.model.ActionInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 健身信息详情信息
 * User:Created by wei.li
 * Date: on 2015/12/10.
 * Time:23:29
 */
public interface IActionInfoService {

    /**
     * 健身信息详情新增
     * @param actionInfo 健身信息详情
     * @return 新增的健身信息详情主键
     */
    Integer create(ActionInfo actionInfo);

    /**
     * 健身信息详情修改
     * @param actionInfo 健身信息详情
     * @return 修改结果（true/false）
     */
    Boolean update(ActionInfo actionInfo);

    /**
     * 健身信息详情详情删除
     * @param id 健身信息详情
     * @return 删除结果（true/false）
     */
    Boolean delete(Integer id);

    /**
     * 根据主键查找健身信息详情
     * @param id 主键信息
     * @return 健身信息
     */
    ActionInfo findById(Integer id);

    /**
     * 根据条件查询健身信息详情
     * @param query 查询条件
     * @return 健身信息详情列表
     */
    List<ActionInfo> list(Map<String,Object> query);


    /**
     * 根据id集合查询健身信息详情
     * @param ids 主键集合
     * @return 健身信息详情列表
     */
    List<ActionInfo> batchQuery(Set<Integer> ids);
}
