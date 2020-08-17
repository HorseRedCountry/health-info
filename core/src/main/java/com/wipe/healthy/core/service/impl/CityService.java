package com.wipe.healthy.core.service.impl;

import com.wipe.healthy.core.dao.read.CityReadDao;
import com.wipe.healthy.core.model.City;
import com.wipe.healthy.core.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 城市信息服务
 * User:Created by wei.li
 * Date: on 2015/12/22.
 * Time:23:05
 */
@Service
public class CityService implements ICityService {

    @Resource
    CityReadDao cityReadDao;
    /**
     * 根据条件查找城市信息
     *
     * @param query 查询条件
     * @return 城市信息列表
     */
    @Override
    public List<City> list(Map<String, Object> query) {
        return this.cityReadDao.list(query);
    }
}
