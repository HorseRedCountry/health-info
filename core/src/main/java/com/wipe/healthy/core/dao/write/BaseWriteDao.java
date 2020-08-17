package com.wipe.healthy.core.dao.write;

/**
 * dao层写操作查询父类接口
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:16:21
 */
public interface BaseWriteDao<T> {

    /**增加**/
    Integer create(T t);

    /**修改**/
    Boolean update(T t);

    /**删除**/
    Boolean delete(Integer id);
}
