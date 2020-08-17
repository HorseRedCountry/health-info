package com.wipe.healthy.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ArrayListMultimap;
import com.wipe.healthy.BaseTest;
import com.wipe.healthy.service.biz.ChartBiz;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * User:Created by wei.li
 * Date: on 2016/3/15.
 * Time:15:31
 */
public class ChartService extends BaseTest {

    @Autowired
    ChartBiz chartBiz;

   @org.junit.Test
    public void test(){
       ArrayListMultimap multimap = chartBiz.weightVPulmonary();
       Map<String,Float> map =  multimap.asMap();
       String json =JSONObject.toJSONString(map);
       System.out.println(json);
    }
}
