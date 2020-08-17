package com.wipe.healthy.core.dao.read;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * dao层读操作查询父类接口
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:19:38
 */
public interface BaseReadDao<T> {

    /** 根据id查询对象**/
    T findById(Integer id);

    /** 根据查询条件查询对象列表**/
    List<T> list(Map<String,Object> query);

    /** 根据ids集合批量查询对象列表**/
    List<T> batchQuery(Set<Integer> ids);
}
