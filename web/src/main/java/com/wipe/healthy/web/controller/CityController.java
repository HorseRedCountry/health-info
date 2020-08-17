package com.wipe.healthy.web.controller;

import com.alibaba.fastjson.JSON;
import com.wipe.healthy.service.biz.CityBiz;
import com.wipe.healthy.web.dto.NodesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 城市信息控制器
 * User:Created by wei.li
 * Date: on 2015/12/23.
 * Time:8:50
 */

@Controller
@RequestMapping(value = "/city")
public class CityController {
    @Resource
    CityBiz cityBiz;

    /**
     * 查找城市输出视图
     * @return 城市输出视图
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<NodesOutput> list(){
        List<NodesOutput> nodesOutputList = cityBiz.list();
        return  nodesOutputList;
    }
}
