package com.wipe.healthy.core.service;

import com.wipe.healthy.core.model.City;

import java.util.List;
import java.util.Map;

/**
 * 城市信息服务层
 * User:Created by wei.li
 * Date: on 2015/12/22.
 * Time:23:01
 */
public interface ICityService {

    /**
     * 根据条件查找城市信息
     * @param query 查询条件
     * @return 城市信息列表
     */
    List<City> list(Map<String,Object> query);
}
